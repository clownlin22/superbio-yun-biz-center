package cn.superbio.judicial.cloud.biz.cases.service;


import cn.superbio.judicial.cloud.biz.cases.entity.DistrictEntity;
import cn.superbio.judicial.cloud.biz.cases.entity.DistrictQueryEntity;

import java.util.List;

public interface DistrictService {
    public List<DistrictEntity> list(DistrictQueryEntity query);

    public DistrictEntity save(DistrictEntity districtEntity);

    public void removeBatch(List<String> codes);

    public DistrictEntity update(DistrictEntity district);

    public void enforcementRemove(List<String> codes);
}
