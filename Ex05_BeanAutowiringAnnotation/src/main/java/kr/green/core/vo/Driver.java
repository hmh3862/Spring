package kr.green.core.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Driver {
	private String name="한사람";
	// 자동 주입 : 주입할 객체가 존재하지 않으면 에러가 나온다. 이때 어레 발생을 막으려면 required = false를 사용한다.
	@Autowired(required = false) 
	private License license;
}
