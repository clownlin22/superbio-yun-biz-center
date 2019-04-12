package cn.superbio.judicial.cloud.biz.cases.consumer;

import cn.superbio.judicial.cloud.biz.cases.PermissionServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("BIZ-CASES")
public interface PermissionServiceConsumer extends PermissionServiceApi {
}
