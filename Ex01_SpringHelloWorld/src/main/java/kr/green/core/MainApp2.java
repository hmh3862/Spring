package kr.green.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.HelloWorld;

public class MainApp2 {
	public static void main(String[] args) {
		// 이 순간 스프링 프레임워크가  설정XML 파일을 읽어서 등록된 모든 객체를 적재한다.
		// 스프링을 경량 컨테이너다!!! -- 애플리케이션에서 사용되는 모든 객체를 저장하고 생성부터 소멸까지 관리를 해준다.
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");
		
		// 이제 필요한 객체는 찾아서 사용하면 된다.
		HelloWorld helloWorld1 = (HelloWorld) context.getBean("helloWorld");
		helloWorld1.sayHello("Spring5");
		
		HelloWorld helloWorld2 = context.getBean("helloWorld", HelloWorld.class);
		helloWorld2.sayHello("Spring4");
		
		// 객체를 2개의 변수를 선언해서 사용했지만 객체는 1개다. 해시코드가 같다.
		System.out.println(helloWorld1.hashCode());
		System.out.println(helloWorld2.hashCode());
		
		context.close();
	}
}
