package top.testeru.testerusphere.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.testeru.testerusphere.service.ProjectService;
import top.testeru.testerusphere.util.R;

import javax.annotation.Resource;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project testerusphere
 * @Description 用例相关
 * @createTime 2022年11月04日 18:56:00
 */
@RestController
@RequestMapping("case")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    /**
     *
     * @return
     */
//    @ApiOperation(value = "用例列表查询")
    @GetMapping()
    public R listCase(){
        return projectService.listCase();
    }

}
