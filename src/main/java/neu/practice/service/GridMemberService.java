package neu.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.practice.entity.GridMember;
import neu.practice.entity.User;

public interface GridMemberService extends IService<GridMember> {
    public GridMember login(String login_code, String password);
    public boolean register(User user);
}
