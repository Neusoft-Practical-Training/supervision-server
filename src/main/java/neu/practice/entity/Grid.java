package neu.practice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@TableName("grid")
public class Grid {
    Integer id;
    String gname;
    Integer pid;
    Integer status;
    Integer level;
    Integer adcode;

    @TableField(exist = false)
    private List<Grid> children =new ArrayList<>();

    @TableField(exist = false)
    private Long count;
}
