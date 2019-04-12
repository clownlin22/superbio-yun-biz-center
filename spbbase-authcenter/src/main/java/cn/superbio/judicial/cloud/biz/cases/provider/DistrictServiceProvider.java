package cn.superbio.judicial.cloud.biz.cases.provider;

import cn.superbio.judicial.cloud.biz.cases.DistrictServiceApi;
import cn.superbio.judicial.cloud.biz.cases.entity.DistrictEntity;
import cn.superbio.judicial.cloud.biz.cases.entity.DistrictQueryEntity;
import cn.superbio.judicial.cloud.biz.cases.service.DistrictService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictServiceProvider implements DistrictServiceApi {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private Mapper dozerMapper;

    @Override
    public List<DistrictEntity> list(@RequestBody DistrictQueryEntity query) { return districtService.list(query); }

    @Override
    public DistrictEntity save(@RequestBody DistrictEntity district) {
        return districtService.save(district);
    }

    @Override
    public DistrictEntity update(@RequestBody DistrictEntity district) {
        return  districtService.update(district);
    }

    @Override
    public void removeBatch(@RequestParam(value="codes",required=true) List<String> codes) {
        districtService.removeBatch(codes);
    }

    @Override
    public void enforcementRemove(@RequestParam(value="codes",required=true) List<String> codes) {
        districtService.enforcementRemove(codes);
    }
}
