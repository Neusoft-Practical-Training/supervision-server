package neu.practice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import neu.practice.entity.Aqi;
import neu.practice.entity.AqiAssignment;
import neu.practice.entity.AqiFeedback;
import neu.practice.entity.AqiStatistics;
import neu.practice.service.AqiAssignmentService;
import neu.practice.service.AqiFeedbackService;
import neu.practice.service.AqiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aqi")
public class AqiController {

    @Autowired
    private AqiService aqiService;
    @Autowired
    private AqiAssignmentService aqiAssignmentService;

    @GetMapping
    public Result getAQI() {
        Result.ResultBuilder builder = Result.builder();
        List<Aqi> afList;
        //分页查询
        try {
            IPage<Aqi> p = new Page<>(1, 10);
            IPage<Aqi> aqiPage = aqiService.page(p); // 调用 page 方法
            afList = aqiPage.getRecords();
        } catch (Exception e) {
            return builder
                    .code(0)
                    .message("获取AQI信息失败")
                    .build();
        }
        return builder
                .code(1)
                .data(afList)
                .message("获取AQI信息成功")
                .build();
    }

    @PostMapping("/getTask/${taskId}")
    public Result getTask(int taskId) {
        Result.ResultBuilder builder = Result.builder();
        AqiAssignment aqiAssignment = aqiAssignmentService.getById(taskId);
        if (aqiAssignment == null) {
            return builder
                    .code(0)
                    .message("获取信息失败")
                    .build();
        }
        return builder
                .code(1)
                .data(aqiAssignment)
                .message("获取信息成功")
                .build();
    }
}
