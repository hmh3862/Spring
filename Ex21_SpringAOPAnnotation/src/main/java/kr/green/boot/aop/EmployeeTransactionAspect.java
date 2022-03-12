package kr.green.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeTransactionAspect {
	
	@Before("execution(* kr.green.boot.service.EmployeeServiceImpl.*(..))")
	public void selectEmployeeId(JoinPoint joinPoint) {
		System.out.println("AOP 호출 : " + joinPoint.getSignature().getName());
	}
}
