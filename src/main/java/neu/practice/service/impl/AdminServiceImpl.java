package neu.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.practice.entity.Admin;
import neu.practice.entity.GridMember;
import neu.practice.entity.User;
import neu.practice.mapper.AdminMapper;
import neu.practice.mapper.GridMemberMapper;
import neu.practice.mapper.UserMapper;
import neu.practice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private GridMemberMapper gridMemberMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Admin login(String login_code, String password){
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(Map.of("login_code", login_code, "password", password));
        Admin account = adminMapper.selectOne(queryWrapper);
        if (account == null) {
            return null;
        }
        if (!password.equals(account.getPassword())){
            return null;
        }
        return account;
    }

    @Override
    public List<GridMember> getAllGridMember(String province){
        QueryWrapper<GridMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("province_id", province);
        List<GridMember> gridMembers = gridMemberMapper.selectList(queryWrapper);
        return gridMembers;
    }

    @Override
    public List<User> getAllSupervisor(String province){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("province_id", province);
        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }

    @Override
    public List<Admin> getAllAdmin(String province){
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("province_id", province);
        List<Admin> admins = adminMapper.selectList(queryWrapper);
        return admins;
    }
}

