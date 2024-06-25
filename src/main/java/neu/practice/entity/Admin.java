package neu.practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admins")
public class Admin extends User {
    private Integer id;
    private String province_id;
    private String city_id;
    private Integer permission;
}
