package neu.practice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import neu.practice.entity.Admin;
import neu.practice.entity.GridMember;
import neu.practice.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> selectSupervisors(User user);

    List<Admin> selectAdmins(Admin admin);

    List<GridMember> selectGridMembers(GridMember gridMember);
}
