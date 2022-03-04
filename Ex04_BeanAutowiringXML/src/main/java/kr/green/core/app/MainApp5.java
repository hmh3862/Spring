package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Performer;

public class MainApp5 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("appConfig4.xml");
		
		Performer performer = context.getBean("performer", Performer.class);
		System.out.print(performer.getName() + "님이 ");
		System.out.println(performer.getInstrument().getName() + "을 연주 합니다.");
		
		context.close();
	}
}
