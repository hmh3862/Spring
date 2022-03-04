package kr.green.core.vo;

public class HelloWorldImpl implements HelloWorld {
	@Override
	public void sayHello(String name) {
		System.out.println(name + "님 반갑습니다.");
	}
}
