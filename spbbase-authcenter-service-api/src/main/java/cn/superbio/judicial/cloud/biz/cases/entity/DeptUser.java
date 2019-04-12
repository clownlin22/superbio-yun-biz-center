package cn.superbio.judicial.cloud.biz.cases.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户_部门信息")
public class DeptUser {
    @ApiModelProperty(value = "用户_部门ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @ApiModelProperty(value = "部门ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long deptId;
    @ApiModelProperty(value = "用户ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
//    @ApiModelProperty(value = "父级ID")
//    private Integer default;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdString() {
        return this.id==null?"":this.id.toString();
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptIdString() {
        return this.deptId==null?"":this.deptId.toString();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserIdString() {
        return this.userId==null?"":this.userId.toString();
    }

}