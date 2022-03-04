package kr.green.core.app;

import java.util.Date;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.core.config.QuestionConfig;
import kr.green.core.vo.Answer;
import kr.green.core.vo.Question;
import kr.green.core.vo.User;

public class QuestionApp2 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(QuestionConfig.class);
		
		Date date = context.getBean("date", Date.class);
		System.out.println(date);
		
		Answer answer1 = context.getBean("answer1", Answer.class);
		System.out.println(answer1);
		
		User user1 = context.getBean("user1", User.class);
		System.out.println(user1);
		
		@SuppressWarnings("unchecked")
		Map<Answer, User> map = context.getBean("map", Map.class);
		System.out.println(map);
		
		Question question1 = context.getBean("question", Question.class);
		System.out.println(question1);
		
		context.close();
	}
}
