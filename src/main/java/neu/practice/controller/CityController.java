package neu.practice.controller;

import neu.practice.entity.Grid;
import neu.practice.service.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private GridService gridService;

    @GetMapping("/{province_id}")
    public Result cities(@PathVariable int province_id){
        Result.ResultBuilder builder = Result.builder();
        // TODO：根据省的id 查询该省所有的城市
        Grid root = gridService.selectAllGridTree();
        if (root.getLevel() == 1 && root.getPid() == province_id){
            return builder
                    .code(1)
                    .data(root.getChildren())
                    .message(null)
                    .build();
        }
        return null;
    }
}
