package neu.practice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import neu.practice.dto.UserDto;
import neu.practice.entity.Admin;
import neu.practice.entity.GridMember;
import neu.practice.entity.User;
import neu.practice.mapper.GridMemberMapper;
import neu.practice.mapper.UserMapper;
import neu.practice.service.AdminService;
import neu.practice.service.GridMemberService;
import neu.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private GridMemberService gridMemberService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GridMemberMapper gridMemberMapper;

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
        boolean userRegisterFlag = false;
        boolean girdMemberRegisterFlag = false;
        if (0 == role) {
            // 管理员不可注册
            return builder
                    .code(0)
                    .data(null)
                    .message("您无法注册成为管理员")
                    .build();
        } else if (2 == role) {
            // TODO:注册公众监督员
            userRegisterFlag = userService.register((User) user);
            if (userRegisterFlag){
                return builder
                        .code(1)
                        .data(null)
                        .message("注册用户成功")
                        .build();
            }else
            return builder
                    .code(1)
                    .data(null)
                    .message("注册公众监督员失败")
                    .build();
        } else if (3 == role) {
            // TODO:注册网格员
            girdMemberRegisterFlag = gridMemberService.register((GridMember) user);
            if (girdMemberRegisterFlag) {
                return builder
                        .code(1)
                        .data(null)
                        .message("注册网格员成功")
                        .build();
            }else
            return builder
                    .code(1)
                    .data(null)
                    .message("注册网格员失败")
                    .build();
        }
        // TODO:根据service返回结果 向用户返回注册结果

        return null;
    }

    //判断
    @PostMapping("/updateUserInfo")
    public Result update(@RequestBody UserDto user) {
        Result.ResultBuilder builder = Result.builder();

        // TODO: 身份校验，只能修改自己的信息

        Integer role = user.getRole();
        if (0 == role) {
            // TODO:修改管理员信息
            adminService.updateById((Admin) user);
            userService.updateById((User) user);
            QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", ((Admin) user).getUser_id());
            Admin account = adminService.getOne(queryWrapper);
            return builder
                    .code(1)
                    .data(account)
                    .message("修改管理员信息成功")
                    .build();
        } else if (2 == role) {
            // TODO:修改公众监督员信息
            userService.updateById((User) user);
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("login_code", user.getLogin_code());
            User account = userService.getOne(queryWrapper);
            return builder
                    .code(1)
                    .data(account)
                    .message("修改公众监督员信息成功")
                    .build();
        } else if (3 == role) {
            // TODO:修改网格员信息
            gridMemberService.updateById((GridMember) user);
            userService.updateById((User) user);
            QueryWrapper<GridMember> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", ((GridMember) user).getUser_id());
            GridMember account = gridMemberService.getOne(queryWrapper);
            return builder
                    .code(1)
                    .data(account)
                    .message("修改网格员信息成功")
                    .build();
        }
        return null;
    }

    @PostMapping("/delete")
    public Result deleteUser(@RequestBody UserDto user) {
        Result.ResultBuilder builder = Result.builder();
        Integer role = user.getRole();
        if (role == 0) {
            // 管理员不可删除
            return builder
                    .code(0)
                    .data(null)
                    .message("您无法删除管理员")
                    .build();
        } else if (role == 2) {
            User account = userService.findByLoginCode((User) user);
            if (account == null) {
                return builder
                        .code(0)
                        .data(null)
                        .message("请输入正确的用户名")
                        .build();
            }
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("login_code", user.getLogin_code());
            userMapper.delete(queryWrapper);
            return builder
                    .code(1)
                    .data(null)
                    .message("删除公众监督员成功")
                    .build();
        } else if (role == 3) {
            GridMember account = gridMemberService.findGridMemberByLoginCode((GridMember) user);
            if (account == null) {
                return builder
                        .code(0)
                        .data(null)
                        .message("请输入正确的用户名")
                        .build();
            }
            QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("login_code", user.getLogin_code());
            QueryWrapper<GridMember> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("login_code", user.getLogin_code());
            userMapper.delete(queryWrapper1);
            gridMemberMapper.delete(queryWrapper2);
            return builder
                    .code(1)
                    .data(null)
                    .message("删除公众监督员成功")
                    .build();
        }
        return null;
    }

    @PostMapping("/setUserStatus/${ userId }")
    public Result setUserStatus(@PathVariable int userid) {
        Result.ResultBuilder builder = Result.builder();
        User user = userService.getById(userid);
        user.setStatus(true);
        User account = userService.setUserStatus(user);
        return builder
                .code(1)
                .data(account)
                .message("设置成功")
                .build();
    }


    @PostMapping("/setUserRemarks")
    public Result setUserStatus(@PathVariable int userid, String remarks) {
        Result.ResultBuilder builder = Result.builder();
        User user = userService.getById(userid);
        user.setRemarks(remarks);
        User account = userService.setUserRemarks(user);
        return builder
                .code(1)
                .data(account)
                .message("设置成功")
                .build();
    }

    private static Result loginSuccess(Result.ResultBuilder builder, Object object) {
        return builder
                .code(1)
                .data(object)
                .message("登录成功")
                .build();
    }

    @PostMapping("/selectSupervisors")
    public Result selectSupervisors(@RequestBody String adminId) {
        Result.ResultBuilder builder = Result.builder();
        User user = userService.getUserByAdminId(adminId);
        List<User> list = userService.selectSupervisors(user);
        return builder.code(1).data(list).build();
    }

    @PostMapping("/selectAdmins")
    public Result selectAdmins(@RequestBody String adminId) {
        Result.ResultBuilder builder = Result.builder();
        Admin admin = adminService.getById(adminId);
        List<Admin> list = userService.selectAdmins(admin);
        return builder.code(1).data(list).build();
    }

    @PostMapping("/selectGridMembers")
    public Result selectGridMembers(@RequestBody String adminId) {
        Result.ResultBuilder builder = Result.builder();
        GridMember gridMember = userService.getGridMembersByAdminId(adminId);
        List<GridMember> list = userService.selectGridMembers(gridMember);
        return builder.code(1).data(list).build();
    }
}