package cn.superbio.judicial.cloud.biz.cases.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "权限管理")
public class PermissionQuery {
    @ApiModelProperty(value = "权限Code")
    private String code;
    @ApiModelProperty(value = "权限名称")
    private String name;
    @ApiModelProperty(value = "权限类型")
    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
