package kr.green.core.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bond {
	
	@Autowired // 자동 주입해라!!!
	@Qualifier("ferari") // 동일한 타입이 여러개 존재할때ㅐ 에러가 발생한다. 이때 이름을 주어서 주입 객체 지정 가능하다.
	private Car car1;
	
	@Autowired
	@Qualifier("mustang")
	private Car car2;
	
	public void showCar() {
		System.out.println("이번 본드카는 " + car1.getCarName() + "입니다.");
		System.out.println("이번 본드카는 " + car2.getCarName() + "입니다.");
	}
}
