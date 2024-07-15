package neu.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.practice.entity.AqiAssignment;
import neu.practice.entity.AqiFeedback;
import neu.practice.entity.AqiStatistics;

public interface AqiAssignmentService extends IService<AqiAssignment> {
    public void assign(AqiAssignment aqiAssignment);

}
