package neu.practice.controller;

import neu.practice.entity.AqiAssignment;
import neu.practice.entity.AqiStatistics;
import neu.practice.service.AqiAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AqiAssignmentService aqiAssignmentService;

    /*
     * 这个参数好像有问题我改了
     */
    @PostMapping("/assign")
    public Result assign(AqiAssignment aqiAssignment) {
        Result.ResultBuilder builder = Result.builder();
        try {
            aqiAssignmentService.assign(aqiAssignment);
        } catch (Exception e) {
            return builder
                    .code(0)
                    .message("指派任务失败，请重试")
                    .build();
        }
        return builder
                .code(1)
                .message("指派任务成功")
                .build();
    }

    @PostMapping("/getTask/${taskId}")
    public Result getTask(AqiStatistics aqiStatistics) {
        Result.ResultBuilder builder = Result.builder();

    }
}
