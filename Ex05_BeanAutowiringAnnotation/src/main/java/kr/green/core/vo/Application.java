package kr.green.core.vo;

import org.springframework.stereotype.Component;
import javax.annotation.Resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component("application") // 객체 등록
public class Application {
	@Resource(name="applicationUser") // 객체를 주입해라(자바기능)
	private ApplicationUser applicationUser;
}
