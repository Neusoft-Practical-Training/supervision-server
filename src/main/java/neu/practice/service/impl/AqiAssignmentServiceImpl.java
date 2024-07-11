package neu.practice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.practice.entity.AqiAssignment;
import neu.practice.entity.AqiFeedback;
import neu.practice.mapper.AqiAssignmentMapper;
import neu.practice.mapper.AqiFeedbackMapper;
import neu.practice.service.AqiAssignmentService;
import neu.practice.service.AqiFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AqiAssignmentServiceImpl extends ServiceImpl<AqiAssignmentMapper, AqiAssignment> implements AqiAssignmentService{

    @Autowired
    private AqiAssignmentMapper aqiAssignmentMapper;

    @Override
    public void assign(AqiAssignment aqiAssignment){
        aqiAssignmentMapper.insert(aqiAssignment);
    }

}

