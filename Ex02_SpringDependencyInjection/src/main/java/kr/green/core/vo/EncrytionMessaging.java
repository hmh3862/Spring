package kr.green.core.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class EncrytionMessaging {
	private Messaging messaging;
	private Encryption encryption;
	
	public EncrytionMessaging() {
		
	}
	public EncrytionMessaging(Messaging messaging) {
		this.messaging = messaging;
	}
	public EncrytionMessaging(Encryption encryption) {
		this.encryption = encryption;
	}
	public EncrytionMessaging(Messaging messaging, Encryption encryption) {
		this.messaging = messaging;
		this.encryption = encryption;
	}
}
