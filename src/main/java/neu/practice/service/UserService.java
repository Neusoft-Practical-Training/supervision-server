package neu.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.practice.entity.User;

public interface UserService extends IService<User> {
    public boolean addUser(User user);
    public User login(String login_code, String password);
    public boolean register(User user);
    public User findByLoginCode(User user);
    public User setUserStatus(User user);
    public User setUserRemarks(User user);
}