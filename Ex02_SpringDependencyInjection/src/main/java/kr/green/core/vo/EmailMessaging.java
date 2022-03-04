package kr.green.core.vo;

public class EmailMessaging implements Messaging {

	@Override
	public void sendMessage() {
		System.out.println("메세지를 Email을 이용하여 전송합니다.");
	}

}
