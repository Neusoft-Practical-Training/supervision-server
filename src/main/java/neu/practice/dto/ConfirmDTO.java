package neu.practice.dto;

/**
 * confirmDTO
 */
@lombok.Data
public class ConfirmDTO {
    /**
     * 任务指派信息编号，任务指派信息编号
     */
    private long aaid;
    /**
     * 地址，反馈信息所在区域详细地址
     */
    private String address;
    /**
     * co级别，一氧化碳级别
     */
    private long coLevel;
    /**
     * co浓度，一氧化碳浓度
     */
    private double coValue;
    /**
     * 确认空气质量ID，确认空气质量ID（外键）
     */
    private long confirmAqiid;
    /**
     * 网格员ID，网格员ID（外键）
     */
    private long gmid;
    /**
     * 网格区域ID，网格区域ID（外键）
     */
    private String gridid;
    /**
     * 备注，备注
     */
    private String remarks;
    /**
     * so2级别，二氧化硫级别
     */
    private long so2Level;
    /**
     * so2浓度，二氧化硫浓度
     */
    private double so2Value;
    /**
     * spm级别，空气悬浮颗粒物级别
     */
    private long spmLevel;
    /**
     * spm浓度，空气悬浮颗粒物浓度
     */
    private double spmValue;
}
