package neu.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.practice.common.CustomException;
import neu.practice.entity.Admin;
import neu.practice.entity.GridMember;
import neu.practice.entity.User;
import neu.practice.mapper.AdminMapper;
import neu.practice.mapper.GridMemberMapper;
import neu.practice.mapper.UserMapper;
import neu.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private GridMemberMapper gridMemberMapper;

    @Override
    public boolean addUser(User user) {
        //处理重名
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(Map.of("login_code", user.getLogin_code()));
        User account = userMapper.selectOne(queryWrapper);
        if (account != null) {
            throw new CustomException("1","请注册新用户");
        }
        //新增
        user.setRole(2);
        int rows = userMapper.insert(user);
        return rows > 0;
    }

    @Override
    public User findByLoginCode(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_code", user.getLogin_code());
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
    public boolean register(User user) {
        return addUser(user);
    }

    @Override
    public User setUserStatus(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_code", user.getLogin_code());
        userMapper.update(queryWrapper);
        return user;
    }

    @Override
    public User setUserRemarks(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_code", user.getLogin_code());
        userMapper.update(queryWrapper);
        return user;
    }

    @Override
    public User getUserByAdminId(String AdminId){
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", AdminId);
        Admin admin = adminMapper.selectOne(queryWrapper);
        String province = admin.getProvince_id();
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("province_id", province);
        return userMapper.selectOne(queryWrapper1);
    }
    @Override
    public List<User> selectSupervisors(User user){
        return userMapper.selectSupervisors(user);
    }
    @Override
    public List<Admin> selectAdmins(Admin admin){
        return userMapper.selectAdmins(admin);
    }
    @Override
    public GridMember getGridMembersByAdminId(String AdminId){
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", AdminId);
        Admin admin = adminMapper.selectOne(queryWrapper);
        String province = admin.getProvince_id();
        QueryWrapper<GridMember> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("province_id", province);
        return gridMemberMapper.selectOne(queryWrapper1);
    }
    @Override
    public List<GridMember> selectGridMembers(GridMember gridMember){
        return userMapper.selectGridMembers(gridMember);
    }
}
