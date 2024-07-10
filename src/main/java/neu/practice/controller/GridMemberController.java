package neu.practice.controller;

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

    /*
     * 这个参数好像有问题我改了
     */
    @PostMapping("/confirm")
    public Result confirm(AqiStatistics aqiStatistics) {
        aqiStatisticsService.confirm(aqiStatistics);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("grid_member confirm")
                .build();
        return result;
    }
}
