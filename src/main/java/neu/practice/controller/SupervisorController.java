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

        System.out.println("supervisor = " + user);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("supervisor registered")
                .build();
        return result;
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {

        boolean flag = userService.updateById(user);
        //
        if (flag) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("Failed to update record.");
        }

        System.out.println("supervisor = " + user);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("supervisor registered")
                .build();
        return result;
    }

    @PostMapping("/feedback")
    public Result feedback() {

        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("supervisor feedback")
                .build();
        return result;
    }

    @PostMapping("/feedback_info/{page}")
    public Result feedbackInfo(@PathVariable int page) {
        // 分页查询
        IPage<AqiFeedback> p = new Page<>(1, page);
        IPage<AqiFeedback> afPage = aqiFeedbackService.page(p); // 调用 page 方法
        //
        List<AqiFeedback> afList = afPage.getRecords();
        long total = afPage.getTotal();
        System.out.println("Total records: " + total);
        for (AqiFeedback af : afList) {
            System.out.println("AqiFeedback: " + af);
        }

        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("supervisor feedback_info; page => " + page)
                .build();
        return result;
    }
}
