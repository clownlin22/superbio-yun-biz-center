package cn.superbio.judicial.cloud.biz.cases.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@TableName("jcb_case_charging")
public class CaseCharging {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long caseId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long chargingItemId;
    private Integer amount;
    private Integer discount;
    private Integer totalPrice;

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
        return chargingItemId;
    }

    public void setEntrustedMatterId(Long entrustedMatterId) {
        this.chargingItemId = entrustedMatterId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getChargingItemId() {
        return chargingItemId;
    }

    public void setChargingItemId(Long chargingItemId) {
        this.chargingItemId = chargingItemId;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}


