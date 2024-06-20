package neu.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grids")
public class GridsController {
    @GetMapping("/{city_id}")
    public Result grids(@PathVariable int city_id){
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("get grid data by city id => " + city_id)
                .build();
        return result;
    }
}
