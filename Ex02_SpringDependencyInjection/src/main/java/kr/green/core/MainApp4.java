package kr.green.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Communication2;

public class MainApp4 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("appConfig2.xml");
		
		Communication2 communication1 = context.getBean("communication1", Communication2.class);
		communication1.communicate();

		Communication2 communication2 = context.getBean("communication2", Communication2.class);
		communication2.communicate();
		
		Communication2 communication3 = context.getBean("communication3", Communication2.class);
		communication3.communicate();
		
		context.close();
	}
}
