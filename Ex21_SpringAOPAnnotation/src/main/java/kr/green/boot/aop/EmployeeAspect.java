package kr.green.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 실행시간을 측정하는 로직
@Component
@Aspect
public class EmployeeAspect {
	long startTime, endTime;
	
	@Before("execution(* kr.green.boot.service.EmployeeServiceImpl.selectById(..))")
	public void beforeLog(JoinPoint joinPoint) {
		startTime = System.currentTimeMillis(); // 시작
		System.out.println("EmployeeAspect.beforeLog() 실행 : " + joinPoint.getSignature().getName());
	}
	
	@After("execution(* kr.green.boot.service.EmployeeServiceImpl.*(..))")
	public void afterLog(JoinPoint joinPoint) {
		endTime = System.currentTimeMillis(); // 종료
		System.out.println("EmployeeAspect.afterLog() 실행 : " + joinPoint.getSignature().getName());
		System.out.println(joinPoint.getSignature().getName() + "의 실행시간 : " + (endTime - startTime) + "ms");
	}
	
	public void afterReturingLog(Object returnValue) {
		System.out.println("EmployeeAspect.afterReturingLog() 실행 : " + returnValue);
	}
	
	public void afterThrowLog(Exception exception) {
		System.out.println("EmployeeAspect.afterThrowLog() 실행 : " + exception);
	}

	public void afterAllLog(JoinPoint joinPoint) {
		System.out.println("EmployeeAspect.afterAllLog() 실행 : " + joinPoint.getSignature().getName());
	}

	public void aroundAllLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("EmployeeAspect.aroundAllLog() 선행 실행");
		proceedingJoinPoint.proceed();
		System.out.println("EmployeeAspect.aroundAllLog() 후행 실행");
	}
	
	@Around("execution(* kr.green.boot.service.EmployeeServiceImpl.*(..))")
	public void aroundTimeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		proceedingJoinPoint.proceed();
		System.out.println(proceedingJoinPoint.getSignature().getName() + "메서드 실행시간 : " + (System.currentTimeMillis()-start) + "ms");
	}
}
