package neu.practice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.practice.entity.AqiStatistics;
import neu.practice.mapper.AqiStatisticsMapper;
import neu.practice.service.AqiFeedbackService;
import neu.practice.service.AqiStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AqiStatisticsServiceImpl extends ServiceImpl<AqiStatisticsMapper, AqiStatistics> implements AqiStatisticsService {

    @Autowired
    private AqiStatisticsMapper AqiStatisticsMapper;



}

