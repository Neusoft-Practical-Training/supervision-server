package neu.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grid")
public class GridController {
    @GetMapping("/{grid_id}")
    public Result grids(@PathVariable int grid_id) {

        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("get grid data by grid id => " + grid_id)
                .build();
        return result;
    }
}
