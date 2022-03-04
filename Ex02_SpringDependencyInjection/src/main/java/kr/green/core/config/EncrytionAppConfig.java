package kr.green.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.green.core.vo.Encryption;
import kr.green.core.vo.EncrytionApp;
import kr.green.core.vo.MD5Encrytion;
import kr.green.core.vo.RSAEncrytion;

@Configuration
public class EncrytionAppConfig {

	public Encryption rsaEncrytion() {
		return new RSAEncrytion();
	}

	public Encryption md5Encrytion() {
		return new MD5Encrytion();
	}
	
	// Setter를 이용한 주입
	@Bean(name = "encrytionApp1")
	public EncrytionApp encrytionApp() {
		EncrytionApp encrytionApp = new EncrytionApp();
		encrytionApp.setEncryption(rsaEncrytion());
		return encrytionApp;
	}
	// 생성자를 이용한 주입
	@Bean(name = "encrytionApp2")
	public EncrytionApp encrytionApp2() {
		return new EncrytionApp(md5Encrytion());
	}
	
}
