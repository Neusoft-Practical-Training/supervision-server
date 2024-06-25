package neu.practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("aqifeedback")
public class AqiFeedback {
    private Integer id;
    private Integer af_id;
    private Integer supervisor_id;
    private Integer pre_aqi_id;
    private Integer aa_id;
    private Integer state;
    private String grid_id;
    private String address;
    private String af_time;
    private String af_date;
    private String explain;
    private String remarks;
}
