package neu.practice.dto;

/**
 * registerDTO
 */
@lombok.Data
public class RegisterDTO {
    /**
     * 年龄，用户年龄
     */
    private Long age;
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
     * 角色，用户角色（三种）
     */
    private long role;
    /**
     * 手机号，用户联系方式
     */
    private String tel;
}

