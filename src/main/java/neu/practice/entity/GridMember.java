package neu.practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("gridmembers")
public class GridMember extends User{
    private Integer id;
    private Integer user_id;
    private Integer task_num;
    private String province_id;
    private String city_id;
    private Integer state;
}
