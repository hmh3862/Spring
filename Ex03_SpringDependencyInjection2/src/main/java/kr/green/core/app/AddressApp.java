package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.AddressVO;

public class AddressApp {
	public static void main(String[] args) {
			AbstractApplicationContext context = 
					new ClassPathXmlApplicationContext("addressConfig.xml");
			
			AddressVO addressVO1 = context.getBean("addr1", AddressVO.class);
			System.out.println(addressVO1);
			
			AddressVO addressVO2 = context.getBean("addr2", AddressVO.class);
			System.out.println(addressVO2);
			
			AddressVO addressVO3 = context.getBean("addr3", AddressVO.class);
			System.out.println(addressVO3);
			
			context.close();
	}
}
