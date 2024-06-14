package neu.practice.dto;

/**
 * loginDTO
 */
@lombok.Data
public class LoginDTO {
    /**
     * 登录编码，登录编码（对于公众监督员，使用其手机号）
     */
    private String loginCode;
    /**
     * 密码，密码
     */
    private String password;
}
