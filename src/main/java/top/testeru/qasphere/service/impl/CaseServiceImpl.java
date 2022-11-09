package top.testeru.qasphere.service.impl;

import org.springframework.stereotype.Service;
import top.testeru.qasphere.converter.TestCaseConverter;
import top.testeru.qasphere.dao.TestCaseMapper;
import top.testeru.qasphere.dto.TestCaseDto;
import top.testeru.qasphere.entity.TestCase;
import top.testeru.qasphere.service.CaseService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description
 * @createTime 2022年11月04日 18:58:00
 */
@Service
public class CaseServiceImpl implements CaseService {
    @Resource
    TestCaseMapper testCaseMapper;
    @Resource
    TestCaseConverter testCaseConverter;
    @Override
    public Optional<List<TestCaseDto>> listCase() {
        List<TestCaseDto> testCaseDtoList = new ArrayList<>();
        List<TestCase> testCaseList = testCaseMapper.selectAll();

        testCaseList.forEach(testCase -> {
            testCaseDtoList.add(
                    testCaseConverter.testCaseForTestCaseDto(testCase));
        });
        return Optional.of(testCaseDtoList);
    }


}
