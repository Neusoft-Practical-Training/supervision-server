package neu.practice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import neu.practice.entity.Aqi;
import neu.practice.mapper.AqiMapper;
import neu.practice.service.AqiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AqiServiceImpl extends ServiceImpl<AqiMapper, Aqi> implements AqiService {

    @Autowired
    private AqiMapper aqiMapper;



}

