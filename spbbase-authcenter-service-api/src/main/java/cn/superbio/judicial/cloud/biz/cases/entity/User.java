package cn.superbio.judicial.cloud.biz.cases.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "用户信息")
public class User {
    @ApiModelProperty(value = "主键")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @ApiModelProperty(value = "登录名")
    private String loginName;
    @ApiModelProperty(value = "昵称")
    private String name;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "是否启用")
    private Integer enabled;
    @ApiModelProperty(value = "角色ID")
    private List<Long> roleId;
    @ApiModelProperty(value = "部门ID")
    private List<Long> deptId;
    public Long getId() {
        return id;
    }
    @ApiModelProperty(value = "用户与部门中间表")
    private DeptUser deptUser;
    @ApiModelProperty(value = "用户与角色中间表")
    private UserRole userRole;

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdString() {
        return this.id==null?"":this.id.toString();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<Long> getRoleId() {
        return roleId;
    }

    public void setRoleId(List<Long> roleId) {
        this.roleId = roleId;
    }

    public List<Long> getDeptId() {
        return deptId;
    }

    public void setDeptId(List<Long> deptId) {
        this.deptId = deptId;
    }

    public DeptUser getDeptUser() {
        return deptUser;
    }

    public void setDeptUser(DeptUser deptUser) {
        this.deptUser = deptUser;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
