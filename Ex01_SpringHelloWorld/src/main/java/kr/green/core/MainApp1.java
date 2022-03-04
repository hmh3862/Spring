package kr.green.core;

import kr.green.core.vo.HelloWorld;
import kr.green.core.vo.HelloWorldImpl;

public class MainApp1 {
	// 지금까지의 자바 객체 사용하는 방법
	public static void main(String[] args) {
		HelloWorld helloWorld1 = new HelloWorldImpl();
		helloWorld1.sayHello("Spring5");
		
		HelloWorld helloWorld2 = new HelloWorldImpl();
		helloWorld2.sayHello("Spring4");
		
		// 해시코드가 다르다 객체가 2개가 생겼다.
		System.out.println(helloWorld1.hashCode());
		System.out.println(helloWorld2.hashCode());
	}
}
