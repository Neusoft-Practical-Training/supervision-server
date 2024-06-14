package neu.practice.dto;


/**
 * userDTO
 */
@lombok.Data
public class UserDTO {
    /**
     * 年龄，用户年龄
     */
    private Long age;
    /**
     * 用户头像，用户头像（base64格式））
     */
    private String avatar;
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
     * 备注，备注
     */
    private String remarks;
    /**
     * 角色，用户角色（三种）
     */
    private long role;
    /**
     * 状态，账号状态（是否可用）
     */
    private boolean status;
    /**
     * 手机号，用户联系方式
     */
    private String tel;
    /**
     * 用户ID，用户ID
     */
    private long userid;
}
