package neu.practice.controller;

import neu.practice.entity.AqiAssignment;
import neu.practice.service.AqiAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AqiAssignmentService aqiAssignmentService;
    /*
     * 这个参数好像有问题我改了
     */
    @PostMapping("/assign")
    public Result assign(AqiAssignment aqiAssignment){
        aqiAssignmentService.assign(aqiAssignment);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("admin assign")
                .build();
        return result;
    }
}
