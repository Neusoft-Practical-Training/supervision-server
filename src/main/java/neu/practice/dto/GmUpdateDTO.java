package neu.practice.dto;

/**
 * gm_updateDTO
 */
@lombok.Data
public class GmUpdateDTO {
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
    private Long gender;
    /**
     * 姓名，用户姓名
     */
    private String name;
    /**
     * 密码，密码
     */
    private String password;
    /**
     * 省编号，省编号（外键）
     */
    private String provinceid;
    /**
     * 备注，备注
     */
    private String remarks;
    /**
     * 手机号，用户联系方式
     */
    private String tel;
    /**
     * 用户ID，用户ID
     */
    private long userid;
}
