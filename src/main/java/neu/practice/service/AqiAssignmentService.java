package neu.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.practice.entity.AqiAssignment;
import neu.practice.entity.AqiFeedback;

public interface AqiAssignmentService extends IService<AqiAssignment> {
    void assign(AqiAssignment aqiAssignment);
}
