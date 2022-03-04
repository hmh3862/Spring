package kr.green.core.vo;

public class Communication2 {
	private Messaging messaging;

	// 생성자를 이용한 주입
	public Communication2(Messaging messaging) {
		this.messaging = messaging;
	}
	
	public void communicate() {
		messaging.sendMessage();
	}
	
}
