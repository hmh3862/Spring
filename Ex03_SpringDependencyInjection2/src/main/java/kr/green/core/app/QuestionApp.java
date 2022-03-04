package kr.green.core.app;

import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Answer;
import kr.green.core.vo.Question;

public class QuestionApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("QuestionConfig.xml");
		
		Date date = context.getBean("date1", Date.class);
		System.out.println(date);
		
		Answer answer1 = context.getBean("answer1", Answer.class);
		System.out.println(answer1);
		
		Answer answer2 = context.getBean("answer2", Answer.class);
		System.out.println(answer2);
		
		Question question1 = context.getBean("question1", Question.class);
		System.out.println(question1);
		
		context.close();
	}
}
