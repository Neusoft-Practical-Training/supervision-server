package neu.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/province")
public class ProvinceController {
    @GetMapping("/{province_name}")
    public Result getProvince(@PathVariable String province_name) {
        System.out.println("province_name = " + province_name);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("get province => " + province_name)
                .build();
        return result;
    }


}
