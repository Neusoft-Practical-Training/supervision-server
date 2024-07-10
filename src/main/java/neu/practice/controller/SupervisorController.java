package neu.practice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import neu.practice.entity.AqiFeedback;
import neu.practice.entity.Supervisor;
import neu.practice.entity.User;
import neu.practice.service.AqiFeedbackService;
import neu.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {
    @Autowired
    private UserService userService;
    private AqiFeedbackService aqiFeedbackService;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.register(user);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("supervisor registered")
                .build();
        return result;
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        userService.updateById(user);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("supervisor registered")
                .build();
        return result;
    }

    /*
    * 这个参数好像有问题我改了
     */
    @PostMapping("/feedback")
    public Result feedback(@RequestBody AqiFeedback aqiFeedback) {
        aqiFeedbackService.feedback(aqiFeedback);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("supervisor feedback")
                .build();
        return result;
    }

    @PostMapping("/feedback_info/{page}")
    public Result feedbackInfo(@PathVariable int page) {
        // 分页查询 接口改一下?, @RequestParam(defaultValue = "10") int size
        IPage<AqiFeedback> p = new Page<>(1, page);
        IPage<AqiFeedback> afPage = aqiFeedbackService.page(p); // 调用 page 方法
        List<AqiFeedback> afList = afPage.getRecords();
        Result result = Result.builder()
                .code(1)
                .data(afList)
                .message("supervisor feedback_info; page => " + page)
                .build();
        return result;
    }
}
