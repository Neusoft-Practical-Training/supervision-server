package neu.practice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import neu.practice.entity.AqiFeedback;
import neu.practice.entity.AqiStatistics;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AqiStatisticsMapper extends BaseMapper<AqiStatistics> {

}
