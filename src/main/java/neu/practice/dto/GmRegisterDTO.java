package neu.practice.dto;

/**
 * gm_registerDTO
 */
@lombok.Data
public class GmRegisterDTO {
    /**
     * 年龄，用户年龄
     */
    private Long age;
    /**
     * 市编号，市编号（外键）
     */
    private String cityid;
    /**
     * 性别，性别（三种）
     */
    private long gender;
    /**
     * 姓名，用户姓名
     */
    private String name;
    /**
     * 密码，用户密码
     */
    private String password;
    /**
     * 省编号，省编号（外键）
     */
    private String provinceid;
    /**
     * 角色，用户角色（三种）
     */
    private long role;
    /**
     * 手机号，用户联系方式
     */
    private String tel;
}
