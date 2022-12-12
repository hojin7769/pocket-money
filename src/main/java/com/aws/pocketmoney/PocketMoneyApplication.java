package com.aws.pocketmoney;

import com.aws.pocketmoney.common.util.ApplicationPropertiesUtils;
import com.aws.pocketmoney.config.AppConfig;
import com.aws.pocketmoney.config.DemocracyBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages = {"com.aws"})
@Import(AppConfig.class)
public class PocketMoneyApplication {

    public static void main(String[] args) {

        String profile = System.getProperty( "spring.profiles.active" , "local" );
        System.setProperty( "spring.profiles.active" , profile );

        ApplicationPropertiesUtils.initEnvProperties();

        System.out.println( "=================== Democracy Server INFO ==================="  );
        System.out.println( "ENV : " + System.getProperty( "env.status" ) );
        System.out.println( "==============================================================\n\n"  );

        SpringApplication democracyApp = new SpringApplication( PocketMoneyApplication.class );
        democracyApp.setBanner( new DemocracyBanner() );
        democracyApp.run( args );

    }

}
