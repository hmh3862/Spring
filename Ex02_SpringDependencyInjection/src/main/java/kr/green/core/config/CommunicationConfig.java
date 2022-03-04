package kr.green.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.green.core.vo.ActiveMQMessaging;
import kr.green.core.vo.Communication;
import kr.green.core.vo.EmailMessaging;
import kr.green.core.vo.Messaging;
import kr.green.core.vo.SMSMessaging;

@Configuration
public class CommunicationConfig {

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
	public Communication communication1() {
		Communication communication = new Communication();
		communication.setMessaging(mqMessaging()); // Seeter를 이용한 주입
		return communication;
	}
	@Bean(name = "communication2")
	public Communication communication2() {
		Communication communication = new Communication();
		communication.setMessaging(smsMessaging());
		return communication;
	}
	@Bean(name = "communication3")
	public Communication communication3() {
		Communication communication = new Communication();
		communication.setMessaging(emailMessaging());
		return communication;
	}
}
