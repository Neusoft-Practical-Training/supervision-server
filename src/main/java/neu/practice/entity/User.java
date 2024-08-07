package neu.practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import neu.practice.dto.UserDto;

@Data
@TableName("users")
public class User extends UserDto {
    private Integer id;
    private String login_code;
    private String password;
    private String tel;
    private String name;
    private Integer gender;
    private Integer role;
    private Integer age;
    private String remarks;
    private Boolean status;
    private String avatar;
    private String create_time;
    private String update_time;
}
