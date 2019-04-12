package cn.superbio.judicial.cloud.biz.cases.consumer;

import cn.superbio.judicial.cloud.biz.cases.DistrictServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("BIZ-CASES")
public interface DistrictServiceConsumer extends DistrictServiceApi {
}
