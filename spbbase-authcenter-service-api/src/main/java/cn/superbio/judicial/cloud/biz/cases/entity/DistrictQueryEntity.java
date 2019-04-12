package cn.superbio.judicial.cloud.biz.cases.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "行政区划信息")
public class DistrictQueryEntity {
    @ApiModelProperty(value = "父区域的行政区划代码", position = 1)
    private String parentCode;
    @ApiModelProperty(value = "行政区划代码", position = 2)
    private String code;
    @ApiModelProperty(value = "行政区域名称", position = 3)
    private String name;

    public DistrictQueryEntity() {
    }

    public DistrictQueryEntity(String parentCode, String code, String name) {
        this.parentCode = parentCode;
        this.code = code;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "DistrictQueryEntity{" +
                "parentCode='" + parentCode + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
