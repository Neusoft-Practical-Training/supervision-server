package neu.practice.dto;

import lombok.Data;

@Data
public class UserDto {
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
    private String province_id;
    private String city_id;
    private Integer permission;
    private Integer task_num;
    private Integer state;
}
