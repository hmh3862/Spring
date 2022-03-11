package kr.green.boot.app;

import java.util.HashMap;
import java.util.Map;

import kr.green.boot.service.TemplateUtil;

public class TemplateEx {
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		map.put("header","머리입니다.");
		map.put("content","내용입니다.<br>내용이라니까요!");
		map.put("footer","꼬리입니다.");
		
		System.out.println(TemplateUtil.getFreeMarkerTemplateContent(map, "template.html"));
		System.out.println("-".repeat(100));
		System.out.println(TemplateUtil.getVelocityTemplateContent(map, "template.html"));
		System.out.println("-".repeat(100));
	}
}


