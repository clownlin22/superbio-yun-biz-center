package cn.superbio.judicial.cloud.biz.cases.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "行政区划查询条件")
public class DistrictQueryVO {
    @ApiModelProperty(value = "父区域的行政区划代码", position = 2)
    private String parentCode;
    @ApiModelProperty(value = "行政区划代码", position = 2)
    private String code;
    @ApiModelProperty(value = "行政区域名称", position = 3)
    private String name;

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
