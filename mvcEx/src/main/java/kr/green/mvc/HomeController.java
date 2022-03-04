package kr.green.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.green.mvc.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/hello")
	public String hello(HttpServletRequest request, Model model) {
		// 요청받기
		String name = request.getParameter("name");
		if(name==null) name = "손";
		// 서비스 호출하여 결과 얻기
		
		// 모델에 결과를 저장하고
		model.addAttribute("name", name);
		// 뷰페이지를 리턴한다.
		return "hello";
	}
	
	@RequestMapping(value = "/hello2")
	public String hello2(@RequestParam(defaultValue = "손") String name, Model model) {
		// 요청받기

		// 서비스 호출하여 결과 얻기
		
		// 모델에 결과를 저장하고
		model.addAttribute("name", name);
		// 뷰페이지를 리턴한다.
		return "hello";
	}
	
	@RequestMapping(value = "/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping(value = "/result")
	public String result(@ModelAttribute UserVO vo, Model model) {
		model.addAttribute("vo", vo);
		return "result";
	}
}
