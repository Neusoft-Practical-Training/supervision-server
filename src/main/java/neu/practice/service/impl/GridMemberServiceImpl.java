package neu.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.practice.entity.GridMember;
import neu.practice.entity.User;
import neu.practice.mapper.GridMemberMapper;
import neu.practice.service.GridMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GridMemberServiceImpl extends ServiceImpl<GridMemberMapper, GridMember> implements GridMemberService {

    @Autowired
    private GridMemberMapper gridMemberMapper;

    @Override
    public GridMember login(String login_code, String password){
        QueryWrapper<GridMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(Map.of("login_code", login_code));
        GridMember account = gridMemberMapper.selectOne(queryWrapper);
        return account;
    }
}
