package top.testeru.testerusphere.converter;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import top.testeru.testerusphere.dto.TestCaseDto;
import top.testeru.testerusphere.entity.TestCase;


/**
 * @author testeru.top
 * @version 1.0.0
 * @Project testerusphere
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
