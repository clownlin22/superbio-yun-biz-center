package cn.superbio.judicial.cloud.biz.cases.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(description = "行政区划信息")
public class DistrictVO {
    @ApiModelProperty(value = "行政区划代码", position = 1, example = "320102")
    @NotBlank
    private String code;
    @ApiModelProperty(value = "行政区域名称", position = 2, example = "玄武区")
    @NotBlank
    private String name;
    @ApiModelProperty(value = "行政区域全称（包含父区域名称）", position = 3, example = "江苏省/南京市/玄武区")
    private String treeNames;
    @ApiModelProperty(value = "行政区域类型", position = 4, example = "4")
    private Integer type;
    @ApiModelProperty(value = "父区域的行政区划代码", position = 5, example = "320100")
    private String parentCode;
    @ApiModelProperty(value = "行政区划排序号", position = 6, example = "1")
    private Integer treeSort;
    @ApiModelProperty(value = "是否是叶子节点", position = 7, example = "true")
    private boolean treeLeaf;
    @ApiModelProperty(value = "备注", position = 8)
    private String remark;

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
}
