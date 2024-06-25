package neu.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.practice.entity.User;

public interface UserService extends IService<User> {
    public void addUser(User user);
    public User login(String login_code, String password);
    public void register(User user);
    public User findByLoginCode(User user);
}