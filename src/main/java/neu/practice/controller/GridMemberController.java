package neu.practice.controller;

import neu.practice.entity.AqiFeedback;
import neu.practice.entity.AqiStatistics;
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


}
