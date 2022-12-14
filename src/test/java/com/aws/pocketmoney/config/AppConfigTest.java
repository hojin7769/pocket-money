package com.aws.pocketmoney.config;

import com.aws.pocketmoney.common.util.ApplicationPropertiesUtils;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;
import java.util.Properties;

@TestConfiguration
@EnableAspectJAutoProxy ( proxyTargetClass=true)
@EnableAsync
@ComponentScan( basePackages = { "com.aws.pocketmoney", }, useDefaultFilters = true )
public class AppConfigTest {


		static {

			    Properties testEnv = new Properties();
				
			    try {
						testEnv.load( AppConfigTest.class.getClassLoader().getResourceAsStream("application-test.properties"));
						ApplicationPropertiesUtils.setEnvProperties( testEnv );
						ApplicationPropertiesUtils.initEnvProperties();
				}
				catch ( IOException e ) {
						e.printStackTrace();
				}
		}
		
		public AppConfigTest() {}

}