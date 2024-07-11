package neu.practice.controller;

import neu.practice.entity.GridMember;
import neu.practice.service.GridMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/province")
public class ProvinceController {

    @GetMapping("/{province_name}")
    public Result getProvince(@PathVariable String province_name) {
        // TODO: 根据省名获取省的编号 根据省的名称进行查询，返回对应的省的编号
        System.out.println("province_name = " + province_name);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("get province => " + province_name)
                .build();
        return result;
    }

    @GetMapping
    public Result getAllProvince() {
        // TODO: 返回全部省名及其编号 查所有
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("get all province")
                .build();
        return result;
    }


}
