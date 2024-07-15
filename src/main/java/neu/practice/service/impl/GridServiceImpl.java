package neu.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.practice.mapper.GridMapper;
import neu.practice.entity.Grid;
import neu.practice.service.GridService;
import org.springframework.stereotype.Service;

@Service
public class GridServiceImpl extends ServiceImpl<GridMapper, Grid> implements GridService {
    @Override
    public Grid selectAllGridTree() {
        LambdaQueryWrapper<Grid> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        int pid = 0;
        lambdaQueryWrapper.eq(Grid::getPid, pid);
        Grid root = getBaseMapper().selectOne(lambdaQueryWrapper);
        fillChildren(root);
        return root;
    }

    private void fillChildren(Grid root) {
        int pid = root.getId();
        LambdaQueryWrapper<Grid> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Grid::getPid, pid);
        root.setChildren(getBaseMapper().selectList(lambdaQueryWrapper));

        if (root.getLevel() >= 3 || root.getChildren() == null || root.getChildren().size() == 0) {
            return;
        }
        if (root.getLevel() < 3) {
            root.getChildren().forEach(this::fillChildren);
        }
    }

}
