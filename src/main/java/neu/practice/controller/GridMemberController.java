package neu.practice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import neu.practice.entity.AqiAssignment;
import neu.practice.entity.AqiFeedback;
import neu.practice.entity.AqiStatistics;
import neu.practice.service.AqiAssignmentService;
import neu.practice.service.AqiStatisticsService;
import neu.practice.service.GridMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grid_member")
public class GridMemberController {

    @Autowired
    private AqiStatisticsService aqiStatisticsService;
    @Autowired
    private AqiAssignmentService aqiAssignmentService;

    @PostMapping("/confirm")
    public Result confirm(AqiStatistics aqiStatistics) {
        Result.ResultBuilder builder = Result.builder();
        try {
            AqiFeedback aqiFeedback = aqiStatisticsService.confirm(aqiStatistics);
            return builder
                    .code(1)
                    .data(aqiFeedback)
                    .message("空气质量上传成功")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return builder
                    .code(0)
                    .message("空气质量上传失败， 请重试")
                    .build();
        }

    }

    @PostMapping("/getConfirmDetail/${confirmId}")
    public Result getConfirmDetail(int confirmId) {
        Result.ResultBuilder builder = Result.builder();
        AqiStatistics aqiStatistics = aqiStatisticsService.getById(confirmId);
        if (aqiStatistics == null) {
            return builder
                    .code(0)
                    .message("获取信息失败")
                    .build();
        }
        return builder
                .code(1)
                .data(aqiStatistics)
                .message("返回数据成功")
                .build();
    }

    @PostMapping("/getConfirmDetailId/${assignId}")
    public Result getConfirmDetailId(int assignId) {
        Result.ResultBuilder builder = Result.builder();
        AqiStatistics aqiStatistics = aqiStatisticsService.getAqiStatisticsByAaid(assignId);
        if (aqiStatistics == null) {
            return builder
                    .code(0)
                    .message("获取信息失败")
                    .build();
        }
        return builder
                .code(1)
                .data(aqiStatistics.getId())
                .message("返回数据成功")
                .build();
    }
}
