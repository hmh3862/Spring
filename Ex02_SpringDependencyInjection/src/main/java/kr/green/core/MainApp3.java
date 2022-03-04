package kr.green.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.core.config.CommunicationConfig;
import kr.green.core.vo.Communication;

public class MainApp3 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(CommunicationConfig.class);
		
		Communication communication1 = context.getBean("communication1", Communication.class);
		communication1.communicate();

		Communication communication2 = context.getBean("communication2", Communication.class);
		communication2.communicate();
		
		Communication communication3 = context.getBean("communication3", Communication.class);
		communication3.communicate();
		
		context.close();
	}
}
