package neu.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.practice.entity.AqiFeedback;
import neu.practice.entity.AqiStatistics;

public interface AqiStatisticsService extends IService<AqiStatistics> {
    void confirm(AqiStatistics aqiStatistics);
}
