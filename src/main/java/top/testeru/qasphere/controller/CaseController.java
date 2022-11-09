package top.testeru.qasphere.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.testeru.qasphere.dto.TestCaseDto;
import top.testeru.qasphere.service.CaseService;
import top.testeru.qasphere.util.R;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description 用例相关
 * @createTime 2022年11月04日 18:56:00
 */
@RestController
@RequestMapping("case")
public class CaseController {
    @Resource
    CaseService caseService;

    /**
     *
     * @return
     */
//    @ApiOperation(value = "用例列表查询")
    @GetMapping
    public R listCase(){
        Optional<List<TestCaseDto>> testCaseDtoList = caseService.listCase();
        if(testCaseDtoList.isEmpty()){
            return R.error().message("用例为空");
        }

        return R.ok().data(testCaseDtoList).message("获取所有用例");
    }

}
