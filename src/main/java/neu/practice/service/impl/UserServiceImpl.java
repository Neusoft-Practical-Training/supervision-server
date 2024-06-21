package neu.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.practice.entity.User;
import neu.practice.mapper.UserMapper;
import neu.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void addUser(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(Map.of("login_code", user.getLogin_code()));
        User account = userMapper.selectOne(queryWrapper);
        if (account != null) {

        }
        userMapper.insert(user);
    }

    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(Map.of("login_code", user.getLogin_code()));
        User account = userMapper.selectOne(queryWrapper);
        if (account == null) {
            return null;
        }
        if (!user.getPassword().equals(account.getPassword())){
            return null;
        }
        return account;
    }
    @Override
    public void register(User user) {

        addUser(user);

    }


}