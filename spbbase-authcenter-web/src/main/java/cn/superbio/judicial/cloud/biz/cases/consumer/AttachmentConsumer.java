package cn.superbio.judicial.cloud.biz.cases.consumer;

import cn.superbio.spbbase.attachment.service.api.AttachmentServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("SPBBASE-ATTACHMENT")
public interface AttachmentConsumer extends AttachmentServiceApi {
}
