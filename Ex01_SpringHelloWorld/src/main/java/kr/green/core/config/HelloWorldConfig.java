package kr.green.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.green.core.vo.HelloWorld;
import kr.green.core.vo.HelloWorldImpl;

@Configuration // 이 클래스를 설정 파일로 사용하겠다.
public class HelloWorldConfig {

	
	@Bean // 객체 등록
	public HelloWorld helloWorld() {
		return new HelloWorldImpl();
	}
}
