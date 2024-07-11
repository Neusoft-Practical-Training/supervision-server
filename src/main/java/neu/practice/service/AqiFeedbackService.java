package neu.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import neu.practice.entity.AqiFeedback;

public interface AqiFeedbackService extends IService<AqiFeedback> {
    public void feedback(AqiFeedback aqiFeedback);
}
