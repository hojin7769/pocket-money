package com.aws.pocketmoney.common.aspect;

import com.aws.pocketmoney.common.util.MDCUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Aspect
public class BridgeAspect {
		
		// Bridge Logger : 로그 파일로 남기는 로거
		private static final Logger bridgeLog = LoggerFactory.getLogger( "BRIDGE_LOG" );
		
		// Bridge Logger : 표준 로거
		private static final Logger log = LoggerFactory.getLogger( "log" );
		
		@Around( "@annotation(com.aws.pocketmoney.common.annotation.Bridge)" )
		public Object bridgeLogging( ProceedingJoinPoint joinPoint ) throws Throwable {
				
				MethodSignature signature = (MethodSignature) joinPoint.getSignature();
				String methodName = signature.getMethod().getName();
				
				Object[] signatureArgs = joinPoint.getArgs();
				StringBuilder sb = new StringBuilder();
				
				for (Object signatureArg: signatureArgs ) {
						String log = signatureArg.toString();
						sb.append( log );
				}
				
				Object result = null;
				try {
						result = joinPoint.proceed();
				}
				finally {
						
						MDCUtils.put( "parameter" , sb.toString() );
						
						
						if ( result != null )  {
								MDCUtils.put( "return" , result.toString() );
						}
						
						String requestUUID = MDCUtils.get( "requestUUID" );
						
						sb.append( " / " ).append( requestUUID );
						
						log.info( sb.toString() );
						bridgeLog.info( "" );
				}
				
				return result;
		}
		
}
