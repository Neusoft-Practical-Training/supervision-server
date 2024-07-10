package neu.practice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import neu.practice.entity.Aqi;
import neu.practice.entity.AqiFeedback;
import neu.practice.service.AqiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aqi")
public class AqiController {

    @Autowired
    private AqiService aqiService;

    @GetMapping
    public Result getAQI() {
        //分页查询
        IPage<Aqi> p = new Page<>(1, 10);
        IPage<Aqi> aqiPage = aqiService.page(p); // 调用 page 方法
        List<Aqi> afList = aqiPage.getRecords();
        Result result = Result.builder()
                .code(1)
                .data(afList)
                .message("get aqi")
                .build();
        return result;
    }
}
