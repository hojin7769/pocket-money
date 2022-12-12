package com.aws.pocketmoney.config;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

/**
 * Democracy Banner
 * */
public class DemocracyBanner implements Banner {
		
		@Override public void printBanner( Environment environment, Class<?> sourceClass, PrintStream out ) {
				
				
				out.println("""
						__________       __           __     _____                             \s
						\\______   \\____ |  | __ _____/  |_  /     \\   ____   ____   ____ ___.__.
						 |     ___/  _ \\|  |/ // __ \\   __\\/  \\ /  \\ /  _ \\ /    \\_/ __ <   |  |
						 |    |  (  <_> )    <\\  ___/|  | /    Y    (  <_> )   |  \\  ___/\\___  |
						 |____|   \\____/|__|_ \\\\___  >__| \\____|__  /\\____/|___|  /\\___  > ____|
						                     \\/    \\/             \\/            \\/     \\/\\/  \s    
						""");
		}
}
