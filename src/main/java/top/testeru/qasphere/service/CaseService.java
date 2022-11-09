package top.testeru.qasphere.service;

import top.testeru.qasphere.dto.TestCaseDto;

import java.util.List;
import java.util.Optional;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project qasphere
 * @Description
 * @createTime 2022年11月04日 18:57:00
 */
public interface CaseService {
    Optional<List<TestCaseDto>> listCase();
}
