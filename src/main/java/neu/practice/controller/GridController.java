package neu.practice.controller;

import neu.practice.entity.Grid;
import neu.practice.service.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grid")
public class GridController {
    @Autowired
    private GridService gridService;
    //这啥几把玩意我没看懂他要干啥？？？有区号了还要区？？？这个得改我瞎写的
    @GetMapping("/{grid_id}")
    public Result grids(@PathVariable int grid_id) {
        Result.ResultBuilder builder = Result.builder();
        Grid root = gridService.selectAllGridTree();
        if (root.getLevel() == 1 && root.getPid() == grid_id){
            return builder
                    .code(1)
                    .data(root.getChildren())
                    .message(null)
                    .build();
        }
        return null;
    }
}
