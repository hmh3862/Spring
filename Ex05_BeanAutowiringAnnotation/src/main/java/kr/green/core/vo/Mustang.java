package kr.green.core.vo;

import org.springframework.stereotype.Component;

@Component
public class Mustang implements Car {
	@Override
	public String getCarName() {
		return "무스탕";
	}
}
