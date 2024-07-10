package neu.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {
    @GetMapping("/{province_id}")
    public Result cities(@PathVariable int province_id){

        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("get cities by province id => " + province_id)
                .build();
        return result;
    }
}
