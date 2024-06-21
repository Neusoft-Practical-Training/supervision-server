package neu.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.practice.entity.User;

public interface UserService extends IService<User> {
    public void addUser(User user);
    public User login(User user);
    public void register(User user);
}