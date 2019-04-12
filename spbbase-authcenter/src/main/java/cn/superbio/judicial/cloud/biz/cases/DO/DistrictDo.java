package cn.superbio.judicial.cloud.biz.cases.DO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("spbbase_district")
public class DistrictDo {
    @TableId
    private String code;
    private String name;
    private String pinyin;
    private String jianpin;
    private Integer type;
    private String parentCode;
    private String parentCodes;
    private Integer treeSort;
    private String treeSorts;
    private Integer treeLeaf;
    private Integer treeDepth;
    private String treeNames;
    private String remark;

    public DistrictDo() {
    }

    public DistrictDo(String code, String name, String pinyin, String jianpin, Integer type, String parentCode, String parentCodes, Integer treeSort, String treeSorts, Integer treeLeaf, Integer treeDepth, String treeNames, String remark) {
        this.code = code;
        this.name = name;
        this.pinyin = pinyin;
        this.jianpin = jianpin;
        this.type = type;
        this.parentCode = parentCode;
        this.parentCodes = parentCodes;
        this.treeSort = treeSort;
        this.treeSorts = treeSorts;
        this.treeLeaf = treeLeaf;
        this.treeDepth = treeDepth;
        this.treeNames = treeNames;
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

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getJianpin() {
        return jianpin;
    }

    public void setJianpin(String jianpin) {
        this.jianpin = jianpin;
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

    public String getParentCodes() {
        return parentCodes;
    }

    public void setParentCodes(String parentCodes) {
        this.parentCodes = parentCodes;
    }

    public Integer getTreeSort() {
        return treeSort;
    }

    public void setTreeSort(Integer treeSort) {
        this.treeSort = treeSort;
    }

    public String getTreeSorts() {
        return treeSorts;
    }

    public void setTreeSorts(String treeSorts) {
        this.treeSorts = treeSorts;
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

    public String getTreeNames() {
        return treeNames;
    }

    public void setTreeNames(String treeNames) {
        this.treeNames = treeNames;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "DistrictDo{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", jianpin='" + jianpin + '\'' +
                ", type=" + type +
                ", parentCode='" + parentCode + '\'' +
                ", parentCodes='" + parentCodes + '\'' +
                ", treeSort=" + treeSort +
                ", treeSorts='" + treeSorts + '\'' +
                ", treeLeaf=" + treeLeaf +
                ", treeDepth=" + treeDepth +
                ", treeNames='" + treeNames + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
