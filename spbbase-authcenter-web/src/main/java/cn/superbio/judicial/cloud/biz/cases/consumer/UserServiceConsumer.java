package cn.superbio.judicial.cloud.biz.cases.consumer;

import cn.superbio.judicial.cloud.biz.cases.UserServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("BIZ-CASES")
public interface UserServiceConsumer extends UserServiceApi {
}
