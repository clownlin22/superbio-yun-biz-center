package cn.superbio.judicial.cloud.biz.cases.consumer;

import cn.superbio.judicial.cloud.biz.cases.DeptServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("BIZ-CASES")
public interface DeptServiceConsumer extends DeptServiceApi {
}
