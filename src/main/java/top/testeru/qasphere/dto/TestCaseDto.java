package top.testeru.qasphere.dto;

import io.swagger.annotations.ApiModel;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project testerusphere
 * @Description
 * @createTime 2022年11月04日 19:02:00
 */

@ApiModel(value = "测试用例实体类",description = "请求参数的测试用例实体类")
public class TestCaseDto {

    private Integer id;


    private String caseTitle;

    /**
     * 备注
     */
    private String remark;

    /**
     * 测试用例内容
     */
    private String caseData;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCaseData() {
        return caseData;
    }

    public void setCaseData(String caseData) {
        this.caseData = caseData;
    }
}
