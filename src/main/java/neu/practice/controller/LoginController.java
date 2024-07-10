package neu.practice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import neu.practice.entity.User;
import neu.practice.mapper.UserMapper;
import neu.practice.service.AdminService;
import neu.practice.service.GridMemberService;
import neu.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    private AdminService adminService;
    private GridMemberService gridMemberService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        //判断用户身份
        User account = userService.findByLoginCode(user);
        if (account.getRole() == 1) {
            adminService.login(user.getLogin_code(), user.getPassword());
        }else if (account.getRole() == 2) {
            userService.login(user.getLogin_code(), user.getPassword());
        }else if (account.getRole() == 3) {
            gridMemberService.login(user.getLogin_code(), user.getPassword());
        }
        Result result = Result.builder()
                .code(1)
                .data(account)
                .message("login controller")
                .build();
        return result;
    }

}
