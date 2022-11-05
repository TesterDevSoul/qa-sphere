package top.testeru.qasphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.testeru.qasphere.service.ProjectService;
import top.testeru.qasphere.util.R;

import javax.annotation.Resource;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description 用例相关
 * @createTime 2022年11月04日 18:56:00
 */
@RestController
@RequestMapping("case")
public class ProjectController {
    @Resource
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
