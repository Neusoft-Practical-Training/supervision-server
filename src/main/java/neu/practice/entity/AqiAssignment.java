package neu.practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("aqiassignment")
public class AqiAssignment {
    private Integer id;
    private Integer aa_id;
    private Integer af_id;
    private Integer as_id;
    private Integer supervisor_id;
    private Integer admin_id;
    private Integer gm_id;
    private Integer cross_domain;
    private Integer completed;
    private String grid_id;
    private String address;
    private String assign_date;
    private String assign_time;
    private String remarks;
}
