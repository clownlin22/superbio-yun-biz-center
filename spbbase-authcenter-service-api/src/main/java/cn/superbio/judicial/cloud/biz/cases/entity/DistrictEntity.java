package cn.superbio.judicial.cloud.biz.cases.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "行政区划信息")
public class DistrictEntity {
    @ApiModelProperty(value = "行政区划代码", position = 1)
    private String code;
    @ApiModelProperty(value = "行政区域名称", position = 2)
    private String name;
    @ApiModelProperty(value = "行政区域全称（包含父区域名称）", position = 3)
    private String treeNames;
    @ApiModelProperty(value = "行政区域类型", position = 4)
    private Integer type;
    @ApiModelProperty(value = "父区域的行政区划代码", position = 5)
    private String parentCode;

    @ApiModelProperty(value = "父区域的行政区划代码", position = 6)
    private String parentCodes;
    @ApiModelProperty(value = "行政区划排序号", position = 7)
    private Integer treeSort;
    @ApiModelProperty(value = "是否是叶子节点", position = 8)
    private boolean treeLeaf;
    @ApiModelProperty(value = "备注", position = 9)
    private String remark;


    public DistrictEntity() {
    }

    public DistrictEntity(String code, String name, String treeNames, Integer type, String parentCode, Integer treeSort, boolean treeLeaf, String remark) {
        this.code = code;
        this.name = name;
        this.treeNames = treeNames;
        this.type = type;
        this.parentCode = parentCode;
        this.treeSort = treeSort;
        this.treeLeaf = treeLeaf;
        this.remark = remark;
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

    public String getTreeNames() {
        return treeNames;
    }

    public void setTreeNames(String treeNames) {
        this.treeNames = treeNames;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getTreeSort() {
        return treeSort;
    }

    public void setTreeSort(Integer treeSort) {
        this.treeSort = treeSort;
    }

    public boolean isTreeLeaf() {
        return treeLeaf;
    }

    public void setTreeLeaf(boolean treeLeaf) {
        this.treeLeaf = treeLeaf;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParentCodes() {
        return parentCodes;
    }

    public void setParentCodes(String parentCodes) {
        this.parentCodes = parentCodes;
    }

    @Override
    public String toString() {
        return "DistrictEntity{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", treeNames='" + treeNames + '\'' +
                ", type=" + type +
                ", parentCode='" + parentCode + '\'' +
                ", parentCodes='" + parentCodes + '\'' +
                ", treeSort=" + treeSort +
                ", treeLeaf=" + treeLeaf +
                ", remark='" + remark + '\'' +
                '}';
    }
}
