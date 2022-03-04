package kr.green.core.vo;

public class Communication {
	private Messaging messaging;

	public Messaging getMessaging() {
		return messaging;
	}
	
	// Setter를 이용한 의존성주입
	public void setMessaging(Messaging messaging) {
		this.messaging = messaging;
	}
	
	public void communicate() {
		messaging.sendMessage();
	}
}
