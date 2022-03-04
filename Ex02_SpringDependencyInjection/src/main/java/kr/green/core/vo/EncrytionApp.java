package kr.green.core.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncrytionApp {
	private Encryption encryption;
	
	public void encrytion() {
		encryption.EncryptData();
	}
}
