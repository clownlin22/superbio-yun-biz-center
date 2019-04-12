package cn.superbio.judicial.cloud.biz.cases.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "角色信息")
public class Role {
    @ApiModelProperty(value = "角色编号")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @ApiModelProperty(value = "角色代码")
    private String code;
    @ApiModelProperty(value = "角色名称")
    private  String name;
    @ApiModelProperty(value = "角色描述")
    private  String description;
    @ApiModelProperty(value = "角色排序")
    private  Integer sort;
    @ApiModelProperty(value = "系统内置")
    private  Integer systemic;
    @ApiModelProperty(value = "是否启用")
    private  Integer enabled;
    @ApiModelProperty(value = "用户编号")
    private List<Long> userId;
    @ApiModelProperty(value = "菜单编号")
    private List<Long> permissionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdString() {
        return this.id==null?"":this.id.toString();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public List<Long> getUserId() {
        return userId;
    }

    public void setUserId(List<Long> userId) {
        this.userId = userId;
    }

    public List<Long> getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(List<Long> permissionId) {
        this.permissionId = permissionId;
    }
}
