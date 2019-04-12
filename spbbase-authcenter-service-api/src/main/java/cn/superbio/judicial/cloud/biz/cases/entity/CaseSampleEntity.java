package cn.superbio.judicial.cloud.biz.cases.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class CaseSampleEntity {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long caseId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long sampleId;
    private Integer appellation;

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

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    public Integer getAppellation() {
        return appellation;
    }

    public void setAppellation(Integer appellation) {
        this.appellation = appellation;
    }

}


