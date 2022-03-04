package kr.green.core;

import kr.green.core.vo.ActiveMQMessaging;
import kr.green.core.vo.Communication;
import kr.green.core.vo.EmailMessaging;
import kr.green.core.vo.Messaging;
import kr.green.core.vo.SMSMessaging;

public class MainApp1 {
	public static void main(String[] args) {
		// 지금까지는 이렇게 주입해서 사용하였다.
		Messaging messaging = new ActiveMQMessaging();
		Communication communication1 = new Communication();
		
		// Setter를 이용한 주입
		communication1.setMessaging(messaging);
		communication1.communicate();

		Messaging messaging2 = new SMSMessaging();
		Communication communication2 = new Communication();
		
		// Setter를 이용한 주입
		communication2.setMessaging(messaging2);
		communication2.communicate();
		
		
		Messaging messaging3 = new EmailMessaging();
		Communication communication3 = new Communication();
		
		// Setter를 이용한 주입
		communication3.setMessaging(messaging3);
		communication3.communicate();
	}
}
