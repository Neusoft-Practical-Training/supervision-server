package neu.practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("aqistatistics")
public class AqiStatistics {
    private Integer id;
    private Integer as_id;
    private Integer aa_id;
    private Integer gm_id;
    private Integer confirm_aqi_id;
    private Integer so2_level;
    private Integer co_level;
    private Integer spm_level;
    private Double so2_value;
    private Double co_value;
    private Double spm_value;
    private String grid_id;
    private String address;
    private String confirm_date;
    private String confirm_time;
    private String explain;
    private String remarks;
}
