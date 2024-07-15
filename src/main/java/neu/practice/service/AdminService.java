package neu.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.practice.entity.Admin;
import neu.practice.entity.GridMember;
import neu.practice.entity.Supervisor;
import neu.practice.entity.User;

import java.util.List;

public interface AdminService extends IService<Admin> {
    public Admin login(String login_code, String password);
    public List<GridMember> getAllGridMember(String province);
    public List<User> getAllSupervisor(String province);
    public List<Admin> getAllAdmin(String province);
}
