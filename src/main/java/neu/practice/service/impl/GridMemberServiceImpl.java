package neu.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.practice.common.CustomException;
import neu.practice.entity.GridMember;
import neu.practice.entity.User;
import neu.practice.mapper.GridMemberMapper;
import neu.practice.mapper.UserMapper;
import neu.practice.service.GridMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GridMemberServiceImpl extends ServiceImpl<GridMemberMapper, GridMember> implements GridMemberService {

    @Autowired
    private GridMemberMapper gridMemberMapper;
    private UserMapper userMapper;

    @Override
    public GridMember login(String login_code, String password){
        QueryWrapper<GridMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(Map.of("login_code", login_code));
        GridMember account = gridMemberMapper.selectOne(queryWrapper);
        return account;
    }

    @Override
    public boolean register(User gridMember) {
        //处理重名
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(Map.of("login_code", gridMember.getLogin_code()));
        User account = userMapper.selectOne(queryWrapper);
        if (account != null) {
            throw new CustomException("1","请注册新用户");
        }
        //user表新增
        gridMember.setRole(3);
        userMapper.insert(gridMember);
        //gridMember表新增
        int rows = gridMemberMapper.insert((GridMember) gridMember);
        return rows > 0;
    }

    @Override
    public GridMember findGridMemberByLoginCode(GridMember gridMember){
        QueryWrapper<GridMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_code", gridMember.getLogin_code());
        return gridMemberMapper.selectOne(queryWrapper);
    }
}
