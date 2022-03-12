package kr.green.boot.aop;

import org.aspectj.lang.JoinPoint;

public class EmployeeTransactionAspect {
	public void selectEmployeeId(JoinPoint joinPoint) {
		System.out.println("AOP 호출 : " + joinPoint.getSignature().getName());
	}
}
