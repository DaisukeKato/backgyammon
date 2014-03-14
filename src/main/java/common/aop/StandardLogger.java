package common.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component
public class StandardLogger {
	
	@Before("execution(* controller.*.*(..)) or execution(* service.*.*(..)) or execution(* domain.*.*(..))")
	public void startMethod(JoinPoint jp){
		String className = jp.getThis().getClass().getName();
		String signatureName = jp.getSignature().getName();
		Logger startMethodLogger = LogManager.getLogger(className);
		startMethodLogger.info(className + '.' + signatureName + " Started");
	}
	
	@After("execution(* controller.*.*(..)) or execution(* service.*.*(..)) or execution(* domain.*.*(..))")
	public void endMethod(JoinPoint jp){
		String className = jp.getThis().getClass().getName();
		String signatureName = jp.getSignature().getName();
		Logger startMethodLogger = LogManager.getLogger(className);
		startMethodLogger.info(className + '.' + signatureName + " End");
	}
	
	@AfterThrowing(value="execution(* service.*.*(..)) or execution(* domain.*.*(..))", throwing="e")
	public void exceptionOccurs(Exception e){
		
	}

}
