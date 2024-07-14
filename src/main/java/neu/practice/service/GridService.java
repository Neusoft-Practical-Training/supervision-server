package neu.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.practice.entity.Grid;

public interface GridService extends IService<Grid>{
    public Grid selectAllGridTree();
}
