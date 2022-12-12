package com.aws.pocketmoney.config;

import com.aws.pocketmoney.common.aspect.BridgeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BeanConfig {
		
		@Bean
		public BridgeAspect bridgeAspect() {
				return new BridgeAspect();
		}
}
