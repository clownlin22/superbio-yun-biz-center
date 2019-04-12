package cn.superbio.judicial.cloud.biz.cases.entity;

import cn.superbio.spbbase.core.pagination.PageQuery;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;
import java.util.List;

public class CaseEntity {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private Integer status;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long caseCategoryId;
    private Date entrustDate;
    private Date acceptDate;
    private Integer deadline;
    private String caseSign;
    private Integer caseNoAutoGenerate;
    private String caseNo;
    private Integer identifiedBefore;
    private Integer urgent;
    private Integer needEvade;
    private Integer materialsCompleted;
    private String caseSummary;
    private String remark;
    private Integer clientType;
    private String clientDept;
    private String clientName;
    private String clientPhone;
    private String clientAddress;
    private Integer reportProvidedType;
    private Integer certTypeForTook;
    private String certIdentify;
    private String recipientName;
    private String recipientPhone;
    private String recipientAddress;
    private Integer totalPrice;
    private String reportPath;
    private Integer downloadCount;
    private List<CaseChargingEntity> caseCharging;
    private List<CaseMaterialEntity> caseMaterial;
    private List<IdentificationMatterEntity> identificationMatter;
    private List<IdentifiedCarEntity> identifiedCar;
    private List<IdentifiedObjectEntity> identifiedObject;
    private List<IdentifiedPersonEntity> identifiedPerson;
    private List<CaseSampleEntity> caseSample;
    private List<SampleEntity> sample;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCaseCategoryId() {
        return caseCategoryId;
    }

    public void setCaseCategoryId(Long caseCategoryId) {
        this.caseCategoryId = caseCategoryId;
    }

    public Date getEntrustDate() {
        return entrustDate;
    }

    public void setEntrustDate(Date entrustDate) {
        this.entrustDate = entrustDate;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public String getCaseSign() {
        return caseSign;
    }

    public void setCaseSign(String caseSign) {
        this.caseSign = caseSign;
    }

    public Integer getCaseNoAutoGenerate() {
        return caseNoAutoGenerate;
    }

    public void setCaseNoAutoGenerate(Integer caseNoAutoGenerate) {
        this.caseNoAutoGenerate = caseNoAutoGenerate;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public Integer getIdentifiedBefore() {
        return identifiedBefore;
    }

    public void setIdentifiedBefore(Integer identifiedBefore) {
        this.identifiedBefore = identifiedBefore;
    }

    public Integer getUrgent() {
        return urgent;
    }

    public void setUrgent(Integer urgent) {
        this.urgent = urgent;
    }

    public Integer getNeedEvade() {
        return needEvade;
    }

    public void setNeedEvade(Integer needEvade) {
        this.needEvade = needEvade;
    }

    public Integer getMaterialsCompleted() {
        return materialsCompleted;
    }

    public void setMaterialsCompleted(Integer materialsCompleted) {
        this.materialsCompleted = materialsCompleted;
    }

    public String getCaseSummary() {
        return caseSummary;
    }

    public void setCaseSummary(String caseSummary) {
        this.caseSummary = caseSummary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public String getClientDept() {
        return clientDept;
    }

    public void setClientDept(String clientDept) {
        this.clientDept = clientDept;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Integer getReportProvidedType() {
        return reportProvidedType;
    }

    public void setReportProvidedType(Integer reportProvidedType) {
        this.reportProvidedType = reportProvidedType;
    }

    public Integer getCertTypeForTook() {
        return certTypeForTook;
    }

    public void setCertTypeForTook(Integer certTypeForTook) {
        this.certTypeForTook = certTypeForTook;
    }

    public String getCertIdentify() {
        return certIdentify;
    }

    public void setCertIdentify(String certIdentify) {
        this.certIdentify = certIdentify;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List<CaseChargingEntity> getCaseCharging() {
        return caseCharging;
    }

    public void setCaseCharging(List<CaseChargingEntity> caseCharging) {
        this.caseCharging = caseCharging;
    }

    public List<CaseMaterialEntity> getCaseMaterial() {
        return caseMaterial;
    }

    public void setCaseMaterial(List<CaseMaterialEntity> caseMaterial) {
        this.caseMaterial = caseMaterial;
    }

    public List<IdentificationMatterEntity> getIdentificationMatter() {
        return identificationMatter;
    }

    public void setIdentificationMatter(List<IdentificationMatterEntity> identificationMatter) {
        this.identificationMatter = identificationMatter;
    }

    public List<IdentifiedCarEntity> getIdentifiedCar() {
        return identifiedCar;
    }

    public void setIdentifiedCar(List<IdentifiedCarEntity> identifiedCar) {
        this.identifiedCar = identifiedCar;
    }

    public List<IdentifiedObjectEntity> getIdentifiedObject() {
        return identifiedObject;
    }

    public void setIdentifiedObject(List<IdentifiedObjectEntity> identifiedObject) {
        this.identifiedObject = identifiedObject;
    }

    public List<IdentifiedPersonEntity> getIdentifiedPerson() {
        return identifiedPerson;
    }

    public void setIdentifiedPerson(List<IdentifiedPersonEntity> identifiedPerson) {
        this.identifiedPerson = identifiedPerson;
    }

    public List<CaseSampleEntity> getCaseSample() {
        return caseSample;
    }

    public void setCaseSample(List<CaseSampleEntity> caseSample) {
        this.caseSample = caseSample;
    }

    public List<SampleEntity> getSample() {
        return sample;
    }

    public void setSample(List<SampleEntity> sample) {
        this.sample = sample;
    }
}
