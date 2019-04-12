package cn.superbio.judicial.cloud.biz.cases.consumer;

import cn.superbio.judicial.cloud.biz.cases.UserRoleServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("BIZ-CASES")
public interface UserRoleServiceConsumer extends UserRoleServiceApi {
}
