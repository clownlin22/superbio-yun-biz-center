package cn.superbio.judicial.cloud.biz.cases.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "部门信息")
public class DeptEntity {
    @ApiModelProperty(value = "部门ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @ApiModelProperty(value = "部门名称")
    private String name;
    @ApiModelProperty(value = "部门类型")
    private Integer type;
    @ApiModelProperty(value = "父级ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;
    @ApiModelProperty(value = "父级ids")
    private String parentIds;
    @ApiModelProperty(value = "排序号")
    private Integer treeSort;
    @ApiModelProperty(value = "排序tree_sorts")
    private String treeSorts;
    @ApiModelProperty(value = "有无上级")
    private Integer treeLeaf;
    @ApiModelProperty(value = "----")
    private Integer treeDepth;
    @ApiModelProperty(value = "----")
    private String treeNames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdString() {
        return this.id==null?"":this.id.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIdString() {
        return this.parentId==null?"":this.parentId.toString();
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getTreeSorts() {
        return treeSorts;
    }

    public void setTreeSorts(String treeSorts) {
        this.treeSorts = treeSorts;
    }

    public String getTreeNames() {
        return treeNames;
    }

    public void setTreeNames(String treeNames) {
        this.treeNames = treeNames;
    }

    public Integer getType() { return type; }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTreeSort() {
        return treeSort;
    }

    public void setTreeSort(Integer treeSort) {
        this.treeSort = treeSort;
    }

    public Integer getTreeLeaf() {
        return treeLeaf;
    }

    public void setTreeLeaf(Integer treeLeaf) {
        this.treeLeaf = treeLeaf;
    }

    public Integer getTreeDepth() {
        return treeDepth;
    }

    public void setTreeDepth(Integer treeDepth) {
        this.treeDepth = treeDepth;
    }
}