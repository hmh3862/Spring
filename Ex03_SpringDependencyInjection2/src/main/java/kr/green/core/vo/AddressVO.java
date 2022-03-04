package kr.green.core.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressVO {
	// 필드들이 모두 같은 타입이다.
	private String city;
	private String state;
	private String country;
}
