package neu.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.practice.entity.Admin;
import neu.practice.entity.GridMember;
import neu.practice.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    public boolean addUser(User user);
    public User login(String login_code, String password);
    public boolean register(User user);
    public User findByLoginCode(User user);
    public User setUserStatus(User user);
    public User setUserRemarks(User user);
    public User getUserByAdminId(String AdminId);
    public List<User> selectSupervisors(User user);
    public List<Admin> selectAdmins(Admin admin);
    public GridMember getGridMembersByAdminId(String AdminId);
    public List<GridMember> selectGridMembers(GridMember gridMember);
}