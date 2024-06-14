package neu.practice.dto;

/**
 * gmDTO
 */
@lombok.Data
public class GmDTO {
    /**
     * 年龄，用户年龄
     */
    private Long age;
    /**
     * 用户头像，用户头像（base64格式））
     */
    private String avatar;
    /**
     * 市编号，市编号（外键）
     */
    private String cityid;
    /**
     * 性别，性别（三种）
     */
    private long gender;
    /**
     * 登录编码，登录编码（对于公众监督员，使用其手机号）
     */
    private String loginCode;
    /**
     * 姓名，用户姓名
     */
    private String name;
    /**
     * 省编号，省编号（外键）
     */
    private String provinceid;
    /**
     * 备注，备注
     */
    private String remarks;
    /**
     * 角色，用户角色（三种）
     */
    private long role;
    /**
     * 网格员状态，网格员状态（六种状态）
     */
    private long state;
    /**
     * 状态，账号状态（是否可用）
     */
    private boolean status;
    /**
     * 任务数量，待完成任务数量
     */
    private long taskNum;
    /**
     * 手机号，用户联系方式
     */
    private String tel;
    /**
     * 用户ID，用户ID
     */
    private long userid;
}
