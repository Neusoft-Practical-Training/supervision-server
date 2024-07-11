package neu.practice.controller;

import neu.practice.dto.UserDto;
import neu.practice.entity.Admin;
import neu.practice.entity.GridMember;
import neu.practice.entity.User;
import neu.practice.service.AdminService;
import neu.practice.service.GridMemberService;
import neu.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private GridMemberService gridMemberService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        Result.ResultBuilder builder = Result.builder();
        //判断用户身份
        User account = userService.findByLoginCode(user);
        // 用户不存在
        if (account == null) {
            return builder
                    .code(0)
                    .data(null)
                    .message("用户不存在")
                    .build();
        }

        // 用户存在
        // 使用密码的MD5值进行比较
        String password = user.getPassword();
        String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(md5);

        // 登录成功
        if (account.getRole() == 0) {
            Admin login = adminService.login(user.getLogin_code(), user.getPassword());
            if (login != null) {
                return loginSuccess(builder, login);
            }
        } else if (account.getRole() == 2) {
            User login = userService.login(user.getLogin_code(), user.getPassword());
            if (login != null) {
                return loginSuccess(builder, login);
            }
        } else if (account.getRole() == 3) {
            GridMember login = gridMemberService.login(user.getLogin_code(), user.getPassword());
            if (login != null) {
                return loginSuccess(builder, login);
            }
        }

        // 登录失败
        return builder
                .code(0)
                .data(null)
                .message("用户名或密码错误")
                .build();
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserDto user) {
        // md5加密
        String password = user.getPassword();
        String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(md5);

        Result.ResultBuilder builder = Result.builder();

        Integer role = user.getRole();
        if (0 == role) {
            // 管理员不可注册
            return builder
                    .code(0)
                    .data(null)
                    .message("您无法注册成为管理员")
                    .build();
        } else if (2 == role) {
            // TODO:注册公众监督员
        } else if (3 == role) {
            // TODO:注册网格员
        }
        // TODO:根据service返回结果 向用户返回注册结果
        return null;
    }

    @PostMapping("/update")
    public Result update(@RequestBody UserDto user) {
        Result.ResultBuilder builder = Result.builder();

        // TODO: 身份校验，只能修改自己的信息

        Integer role = user.getRole();
        if (0 == role) {
            // TODO：修改管理员信息
        } else if (2 == role) {
            // TODO: 修改公众监督员信息
        } else if (3 == role) {
            // TODO: 修改网格员信息
        }
        return null;
    }



    private static Result loginSuccess(Result.ResultBuilder builder, Object object) {
        return builder
                .code(1)
                .data(object)
                .message("登录成功")
                .build();
    }
}