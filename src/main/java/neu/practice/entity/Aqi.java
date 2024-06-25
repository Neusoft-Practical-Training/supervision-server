package neu.practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("aqi")
public class Aqi {
    private Integer id;
    private Integer aqi_id;
    private String chinese_explain;
    private String aqi_explain;
    private String color;
    private String health_impact;
    private String suggestions;
    private Double so2_min;
    private Double so2_max;
    private Double co_min;
    private Double co_max;
    private Double spm_min;
    private Double spm_max;
    private String remarks;
}
