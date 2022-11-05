package top.testeru.testerusphere.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.testeru.testerusphere.converter.TestCaseConverter;
import top.testeru.testerusphere.dao.TestCaseMapper;
import top.testeru.testerusphere.dto.TestCaseDto;
import top.testeru.testerusphere.entity.TestCase;
import top.testeru.testerusphere.service.ProjectService;
import top.testeru.testerusphere.util.R;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project testerusphere
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
