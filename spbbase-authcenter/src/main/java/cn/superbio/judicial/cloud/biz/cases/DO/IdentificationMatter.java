package cn.superbio.judicial.cloud.biz.cases.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@TableName("jcb_identification_matter")
public class IdentificationMatter {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long caseId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long entrustedMatterId;
    private Integer amount;
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Long getEntrustedMatterId() {
        return entrustedMatterId;
    }

    public void setEntrustedMatterId(Long entrustedMatterId) {
        this.entrustedMatterId = entrustedMatterId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}


