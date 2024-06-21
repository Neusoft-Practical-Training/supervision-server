package neu.practice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import neu.practice.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
