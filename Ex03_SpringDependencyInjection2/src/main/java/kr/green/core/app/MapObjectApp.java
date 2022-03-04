package kr.green.core.app;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.MapObject;

public class MapObjectApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("mapConfig.xml");
		
		MapObject mapObject1 = context.getBean("mapObject1", MapObject.class);
		System.out.println(mapObject1);
		
		MapObject mapObject2 = context.getBean("mapObject2", MapObject.class);
		System.out.println(mapObject2);
		
		MapObject mapObject3 = context.getBean("mapObject3", MapObject.class);
		System.out.println(mapObject3);
		
		@SuppressWarnings("unchecked")
		Map<String, Integer> map = context.getBean("map", Map.class);
		System.out.println(map);
		
		context.close();
	}
}
