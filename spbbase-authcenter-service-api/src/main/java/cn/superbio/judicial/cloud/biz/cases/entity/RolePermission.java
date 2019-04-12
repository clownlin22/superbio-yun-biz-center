package cn.superbio.judicial.cloud.biz.cases.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "角色的权限")
public class RolePermission {
    @ApiModelProperty(value = "角色的权限ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @ApiModelProperty(value = "角色ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;
    @ApiModelProperty(value = "权限ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long permissionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdString() {
        return this.id==null?"":this.id.toString();
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long userId) {
        this.permissionId = userId;
    }

    public String getPermissionIdString() {
        return this.permissionId==null?"":this.permissionId.toString();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleIdString() {
        return this.roleId==null?"":this.roleId.toString();
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", permissionId=" + permissionId +
                ", roleId=" + roleId +
                '}';
    }
}