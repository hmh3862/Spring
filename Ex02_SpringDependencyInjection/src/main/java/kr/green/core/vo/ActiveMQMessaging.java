package kr.green.core.vo;

public class ActiveMQMessaging implements Messaging {

	@Override
	public void sendMessage() {
		System.out.println("메세지를 ActiveMQ를 이용하여 전송합니다.");		
	}

}
