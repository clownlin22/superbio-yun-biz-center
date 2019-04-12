package cn.superbio.judicial.cloud.biz.cases.autoconfigure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan( "cn.superbio.judicial.cloud.biz.cases.mapper*" )
@ComponentScan(basePackages = {"cn.superbio.judicial.cloud.biz.cases.provider", "cn.superbio.judicial.cloud.biz.cases.service"})
public class BizCasesAutoConfiguration {
}
