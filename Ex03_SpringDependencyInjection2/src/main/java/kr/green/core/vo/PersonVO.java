package kr.green.core.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonVO {
	// 두개는 객체형이고 1개는 기본 자료형일때 어떻게 주입을 해야 할까요?
	private String name;
	private int age;
	private AddressVO address;
}
