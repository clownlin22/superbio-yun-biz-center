package cn.superbio.judicial.cloud.biz.cases.consumer;

import cn.superbio.judicial.cloud.biz.cases.RoleServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author XiangKang on 2018/6/26.
 */
@FeignClient("BIZ-CASES")
public interface RoleServiceConsumer extends RoleServiceApi {
}
