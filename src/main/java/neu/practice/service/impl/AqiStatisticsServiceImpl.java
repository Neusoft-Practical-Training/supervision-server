package neu.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.practice.entity.AqiAssignment;
import neu.practice.entity.AqiFeedback;
import neu.practice.entity.AqiStatistics;
import neu.practice.mapper.AqiAssignmentMapper;
import neu.practice.mapper.AqiFeedbackMapper;
import neu.practice.mapper.AqiStatisticsMapper;
import neu.practice.service.AqiFeedbackService;
import neu.practice.service.AqiStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AqiStatisticsServiceImpl extends ServiceImpl<AqiStatisticsMapper, AqiStatistics> implements AqiStatisticsService {

    @Autowired
    private AqiStatisticsMapper aqiStatisticsMapper;
    @Autowired
    private AqiAssignmentMapper aqiAssignmentMapper;
    @Autowired
    private AqiFeedbackMapper aqiFeedbackMapper;

    @Override
    public AqiFeedback confirm(AqiStatistics aqiStatistics){
        aqiStatisticsMapper.insert(aqiStatistics);
        int aaid = aqiStatistics.getAa_id();
        QueryWrapper<AqiAssignment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("aa_id", aaid);
        AqiAssignment aqiAssignment = aqiAssignmentMapper.selectOne(queryWrapper);
        QueryWrapper<AqiFeedback> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("af_id", aqiAssignment.getAf_id());
        AqiFeedback aqiFeedback = aqiFeedbackMapper.selectOne(queryWrapper1);
        return aqiFeedback;
    }

    @Override
    public AqiStatistics getAqiStatisticsByAaid(int aaid){
        QueryWrapper<AqiStatistics> queryWrapper = new QueryWrapper<AqiStatistics>();
        queryWrapper.eq("aa_id", aaid);
        return aqiStatisticsMapper.selectOne(queryWrapper);
    }



}

