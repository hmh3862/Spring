package kr.green.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.core.config.CommunicationConfig2;
import kr.green.core.vo.Communication2;

public class MainApp5 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(CommunicationConfig2.class);
		
		Communication2 communication1 = context.getBean("communication1", Communication2.class);
		communication1.communicate();

		Communication2 communication2 = context.getBean("communication2", Communication2.class);
		communication2.communicate();
		
		Communication2 communication3 = context.getBean("communication3", Communication2.class);
		communication3.communicate();
		
		context.close();
	}
}
