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

    // TODO:    deleted
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

    // TODO:    deleted
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
        Result.ResultBuilder builder = Result.builder();
        try {
            aqiFeedbackService.feedback(aqiFeedback);
        } catch (Exception e) {
            return builder
                    .code(0)
                    .message("反馈信息失败，请重试")
                    .build();
        }
        return builder
                .code(0)
                .message("反馈信息成功")
                .build();
    }

    @PostMapping("/feedback_info/{page}")
    public Result feedbackInfo(@PathVariable int page) {
        Result.ResultBuilder builder = Result.builder();
        List<AqiFeedback> afList;
        try {
            // 分页查询 接口改一下?, @RequestParam(defaultValue = "10") int size
            IPage<AqiFeedback> p = new Page<>(1, page);
            IPage<AqiFeedback> afPage = aqiFeedbackService.page(p); // 调用 page 方法
            afList = afPage.getRecords();
        } catch (Exception e) {
            e.printStackTrace();
            return builder
                    .code(1)
                    .message("获取历史信息失败，请重试")
                    .build();
        }

        return Result.builder()
                .code(1)
                .data(afList)
                .message("获取历史信息成功")
                .build();
    }
}
