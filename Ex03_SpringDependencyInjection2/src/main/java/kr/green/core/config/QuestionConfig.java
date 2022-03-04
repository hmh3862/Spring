package kr.green.core.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.green.core.vo.Answer;
import kr.green.core.vo.Question;
import kr.green.core.vo.User;

@Configuration
public class QuestionConfig {

	@Bean("date")
	public Date date() {
		return new Date(System.currentTimeMillis());
	}
	
	@Bean("answer1")
	public Answer answer1() {
		return new Answer(1, "자바", new Date(System.currentTimeMillis()));
	}

	@Bean("answer2")
	public Answer answer2() {
		return new Answer(2, "JSP", date());
	}
	
	@Bean("user1")
	public User user1() {
		return new User(1, "한사람", "xxxx@xxx.com");
	}
	@Bean("user2")
	public User user2() {
		return new User(2, "두사람", "xyz@xxx.com");
	}
	
	@Bean("map") // 객체 등록
	public Map<Answer, User> map(){
		Map<Answer, User> map = new HashMap<>();
		map.put(answer1(), user1());
		map.put(answer2(), user2());
		map.put(new Answer(2, "자바", date()), new User(3, "세사람", "zzz@zzz.com"));
		return map;
	}
	
	@Bean("question")
	public Question question() {
		return new Question(1, "출제자", map());
	}
}
