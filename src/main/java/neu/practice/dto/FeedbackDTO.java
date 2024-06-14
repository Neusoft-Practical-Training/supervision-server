package neu.practice.dto;

/**
 * feedbackDTO
 */
@lombok.Data
public class FeedbackDTO {
    /**
     * 地址，反馈区域详细地址
     */
    private String address;
    /**
     * 反馈信息描述，反馈信息描述
     */
    private String explain;
    /**
     * 网格ID，反馈区域ID
     */
    private String gridid;
    /**
     * 预期AQI，预期AQI信息
     */
    private long preAqiid;
    /**
     * 备注，备注
     */
    private String remarks;
    /**
     * 所属公众监督员ID，所属公众监督员ID
     */
    private long supervisorid;
}
