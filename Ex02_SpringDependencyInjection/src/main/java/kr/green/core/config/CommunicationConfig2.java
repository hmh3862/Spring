package kr.green.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.green.core.vo.ActiveMQMessaging;
import kr.green.core.vo.Communication2;
import kr.green.core.vo.EmailMessaging;
import kr.green.core.vo.Messaging;
import kr.green.core.vo.SMSMessaging;

@Configuration
public class CommunicationConfig2 {

	//@Bean(name = "messaging1")
	public Messaging mqMessaging() {
		return new ActiveMQMessaging();
	}
	//@Bean(name = "messaging2")
	public Messaging smsMessaging() {
		return new SMSMessaging();
	}
	//@Bean(name = "messaging3")
	public Messaging emailMessaging() {
		return new EmailMessaging();
	}
	
	@Bean(name = "communication1")
	public Communication2 communication1() {
		return new Communication2(mqMessaging());
	}
	@Bean(name = "communication2")
	public Communication2 communication2() {
		return new Communication2(smsMessaging());
	}
	@Bean(name = "communication3")
	public Communication2 communication3() {
		return new Communication2(emailMessaging());
	}
}
