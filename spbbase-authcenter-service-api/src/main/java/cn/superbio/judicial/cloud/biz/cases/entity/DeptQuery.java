package cn.superbio.judicial.cloud.biz.cases.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "部门信息")
public class DeptQuery {
    @ApiModelProperty(value = "部门父级编码")
    private String parentId;
    @ApiModelProperty(value = "部门编码")
    private String id;
    @ApiModelProperty(value = "部门名称")
    private String name;
    @ApiModelProperty(value = "部门类型")
    private String type;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
