package top.testeru.qasphere.service.impl;

import org.springframework.stereotype.Service;
import top.testeru.qasphere.converter.TestCaseConverter;
import top.testeru.qasphere.dao.TestCaseMapper;
import top.testeru.qasphere.dto.TestCaseDto;
import top.testeru.qasphere.entity.TestCase;
import top.testeru.qasphere.service.ProjectService;
import top.testeru.qasphere.util.R;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description
 * @createTime 2022年11月04日 18:58:00
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    TestCaseMapper testCaseMapper;
    @Resource
    TestCaseConverter testCaseConverter;
    @Override
    public R listCase() {
        List<TestCaseDto> testCaseDtoList = new ArrayList<>();
        List<TestCase> testCaseList = testCaseMapper.selectAll();

        testCaseList.forEach(testCase -> {
            testCaseDtoList.add(
                    testCaseConverter.testCaseForTestCaseDto(testCase));
        });
        if(testCaseDtoList.isEmpty()){
            return R.error().message("用例为空");
        }

        return R.ok().data(testCaseDtoList).message("获取所有用例");
    }


}
