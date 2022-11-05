package top.testeru.qasphere.converter;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import top.testeru.qasphere.dto.TestCaseDto;
import top.testeru.qasphere.entity.TestCase;


/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description
 * @createTime 2022年11月04日 19:01:00
 */
@Mapper(componentModel = "spring")
public interface TestCaseConverter {
//    TestCaseDto ---->  TestCase

    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "caseTitle",source = "caseTitle"),
            @Mapping(target = "caseData",source = "caseData"),
            @Mapping(target = "remark",source = "remark")

    })
    public TestCase testCaseDtoForTestCase(TestCaseDto testCaseDto);

    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "caseTitle",source = "caseTitle"),
            @Mapping(target = "caseData",source = "caseData"),
            @Mapping(target = "remark",source = "remark")

    })
    public TestCaseDto testCaseForTestCaseDto(TestCase testCase);
}
