package neu.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.practice.entity.AqiFeedback;
import neu.practice.mapper.AqiFeedbackMapper;
import neu.practice.service.AqiFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AqiFeedbackServiceImpl extends ServiceImpl<AqiFeedbackMapper, AqiFeedback> implements AqiFeedbackService{

    @Autowired
    private AqiFeedbackMapper aqiFeedbackMapper;

    @Override
    public AqiFeedback feedback(AqiFeedback aqiFeedback){
        aqiFeedbackMapper.insert(aqiFeedback);
        return aqiFeedback;
    }

}

