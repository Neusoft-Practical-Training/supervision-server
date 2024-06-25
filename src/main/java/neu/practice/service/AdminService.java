package neu.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.practice.entity.Admin;
import neu.practice.entity.User;

public interface AdminService extends IService<Admin> {
    public Admin login(String login_code, String password);
}
