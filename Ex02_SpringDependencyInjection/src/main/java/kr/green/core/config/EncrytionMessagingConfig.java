package kr.green.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.green.core.vo.ActiveMQMessaging;
import kr.green.core.vo.Encryption;
import kr.green.core.vo.EncrytionMessaging;
import kr.green.core.vo.MD5Encrytion;
import kr.green.core.vo.Messaging;

@Configuration
public class EncrytionMessagingConfig {

	public Encryption md5Encrytion() {
		return new MD5Encrytion();
	}
	public Messaging mqMessaging() {
		return new ActiveMQMessaging();
	}
	
	@Bean("encrytionMessaging1") // Setter만을 이용한 주입
	public EncrytionMessaging encrytionMessaging1() {
		EncrytionMessaging encrytionMessaging = new EncrytionMessaging();
		encrytionMessaging.setEncryption(md5Encrytion());
		encrytionMessaging.setMessaging(mqMessaging());
		return encrytionMessaging;
	}
	@Bean("encrytionMessaging2") // 생성자만을 이용한 주입
	public EncrytionMessaging encrytionMessaging2() {
		EncrytionMessaging encrytionMessaging = new EncrytionMessaging(mqMessaging(), md5Encrytion());
		return encrytionMessaging;
	}
	@Bean("encrytionMessaging3") // 생성자와 Setter를 이용한 주입
	public EncrytionMessaging encrytionMessaging3() {
		EncrytionMessaging encrytionMessaging = new EncrytionMessaging(mqMessaging());
		encrytionMessaging.setEncryption(md5Encrytion());
		return encrytionMessaging;
	}
	@Bean("encrytionMessaging4") // 생성자와 Setter를 이용한 주입
	public EncrytionMessaging encrytionMessaging4() {
		EncrytionMessaging encrytionMessaging = new EncrytionMessaging(md5Encrytion());
		encrytionMessaging.setMessaging(mqMessaging());
		return encrytionMessaging;
	}
}
