package neu.practice.dto;

/**
 * assignmentDTO
 */
@lombok.Data
public class AssignmentDTO {
    /**
     * 详细地址，任务区域详细地址
     */
    private String address;
    /**
     * 管理员ID，指派任务管理员ID
     */
    private long adminid;
    /**
     * 空气质量反馈信息编号，空气质量反馈信息编号（外键）
     */
    private long afid;
    /**
     * 是否跨域，是否跨域（默认为0:未跨域）
     */
    private boolean crossDomain;
    /**
     * 网格员ID，指定网格员ID（如果跨域，则由对方区域管理员指定网格员）
     */
    private Long gmid;
    /**
     * 网格ID，任务区域网格ID
     */
    private String gridid;
    /**
     * 备注，备注
     */
    private String remarks;
    /**
     * 公众监督员ID，反馈信息公众监督员ID
     */
    private long supervisorid;
}
