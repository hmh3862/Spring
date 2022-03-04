package kr.green.core.vo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {
	private int id;
	private String name;
	private Map<Answer, User> map;
}
// 문제 : Question클래스를 스프링에 등록하여 사용하는 예제를 만드시오
//        XML로도 만들고 Annotation으로도 해보시오!!!!