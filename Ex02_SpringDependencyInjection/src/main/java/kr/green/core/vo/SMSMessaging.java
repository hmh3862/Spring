package kr.green.core.vo;

public class SMSMessaging implements Messaging{

	@Override
	public void sendMessage() {
		System.out.println("메세지를 SMS를 이용하여 전송합니다.");
	}

}
