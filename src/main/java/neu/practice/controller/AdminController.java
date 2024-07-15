package neu.practice.controller;

import neu.practice.entity.Admin;
import neu.practice.entity.AqiAssignment;
import neu.practice.entity.AqiStatistics;
import neu.practice.service.AdminService;
import neu.practice.service.AqiAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AqiAssignmentService aqiAssignmentService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/assign")
    public Result assign(AqiAssignment aqiAssignment) {
        Result.ResultBuilder builder = Result.builder();
        try {
            aqiAssignmentService.assign(aqiAssignment);
        } catch (Exception e) {
            return builder
                    .code(0)
                    .message("指派任务失败，请重试")
                    .build();
        }
        return builder
                .code(1)
                .message("指派任务成功")
                .build();
    }

    @PostMapping("/getGridMembers/${ adminId }")
    public Result getGridMembers(@PathVariable int adminId) {
        Result.ResultBuilder builder = Result.builder();
        Admin admin = adminService.getById(adminId);
        return builder
                .code(1)
                .data(adminService.getAllGridMember(admin.getProvince_id()))
                .message("获取辖区网格员成功")
                .build();
    }

    @PostMapping("/getSupervisors/${ adminId }")
    public Result getSupervisors(@PathVariable int adminId) {
        Result.ResultBuilder builder = Result.builder();
        Admin admin = adminService.getById(adminId);
        return builder
                .code(1)
                .data(adminService.getAllSupervisor(admin.getProvince_id()))
                .message("获取辖区公众监督员成功")
                .build();
    }

    @PostMapping("/getAdmins/${ adminId }")
    public Result getAdmins(@PathVariable int adminId) {
        Result.ResultBuilder builder = Result.builder();
        Admin admin = adminService.getById(adminId);
        return builder
                .code(1)
                .data(adminService.getAllAdmin(admin.getProvince_id()))
                .message("获取辖区管理员成功")
                .build();
    }
}
