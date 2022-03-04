package kr.green.core.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component("applicationUser")
public class ApplicationUser {
	private String name = "한사람";
}
