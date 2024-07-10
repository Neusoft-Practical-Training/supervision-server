package neu.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.practice.common.CustomException;
import neu.practice.entity.User;
import neu.practice.mapper.UserMapper;
import neu.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        //处理重名
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(Map.of("login_code", user.getLogin_code()));
        User account = userMapper.selectOne(queryWrapper);
        if (account != null) {
            throw new CustomException("1","请注册新用户");
        }
        //新增
        user.setRole(1);
        userMapper.insert(user);
    }

    @Override
    public User findByLoginCode(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(Map.of("login_code", user.getLogin_code()));
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User login(String login_code, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(Map.of("login_code", login_code, "password", password));
        User account = userMapper.selectOne(queryWrapper);
        return account;
    }

    @Override
    public void register(User user) {
        addUser(user);
    }

}
