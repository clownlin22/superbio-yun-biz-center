package cn.superbio.judicial.cloud.biz.cases.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "角色信息")
public class RoleQuery {
    @ApiModelProperty(value = "角色代码")
    private String code;
    @ApiModelProperty(value = "角色名称")
    private  String name;
    @ApiModelProperty(value = "系统内置")
    private  Integer systemic;
    @ApiModelProperty(value = "是否启用")
    private  Integer enabled;

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

    public Integer getSystemic() {
        return systemic;
    }

    public void setSystemic(Integer systemic) {
        this.systemic = systemic;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
