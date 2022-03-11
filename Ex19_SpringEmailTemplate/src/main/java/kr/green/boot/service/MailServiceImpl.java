package kr.green.boot.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.spring.VelocityEngineUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
    VelocityEngine velocityEngine;
     
    @Autowired
    Configuration freemarkerConfiguration;

	@Override
	public void sendEmail() {
		// 메일 보내기 준비하는 객체
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				helper.setFrom("itsungnam201111@gmail.com");// 보내는 사람 아이디
				helper.setTo("itsungnam201111@gmail.com");// 받는 사람 아이디
				helper.setSubject("제목이란다.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); // 제목
				Map<String, Object> map = new HashMap<>();
				map.put("name", "한사람");
				map.put("order", "자동차");
				map.put("content", "하하하하하하");
				helper.setText(getFreeMarkerTemplateContent(map), true);
			}
		};
		try {
            mailSender.send(preparator);
            System.out.println("메일을 성공적으로 보냈습니다.");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
		
	}

	@Override
	public void sendEmail(String toAddress, String subject, String content) {
		try {
			mailSender.send(new MimeMessagePreparator() {
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {

					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					helper.setFrom("itsungnam201111@gmail.com");// 보내는 사람 아이디
					helper.setTo(toAddress);// 받는 사람 아이디
					helper.setSubject(subject); // 제목
					
					Map<String, Object> map = new HashMap<>();
					map.put("name", "한사람");
					map.put("order", "자동차");
					map.put("content", content);
					
					helper.setText(getVelocityTemplateContent(map), true);
					
				}
			});
			System.out.println("메일을 성공적으로 보냈습니다.");
		}catch (MailException e) {
			System.out.println("에러 : " + e.getMessage());
		}
		
	}
	
	@Override
	public void sendEmail(String toAddress, String subject, String name, String order) {
		try {
			mailSender.send(new MimeMessagePreparator() {
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {

					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					helper.setFrom("itsungnam201111@gmail.com");// 보내는 사람 아이디
					helper.setTo(toAddress);// 받는 사람 아이디
					helper.setSubject(subject); // 제목
					
					Map<String, Object> map = new HashMap<>();
					map.put("name", name);
					map.put("order", order);
					
					helper.setText(getFreeMarkerTemplateContent(map), true);
					
				}
			});
			System.out.println("메일을 성공적으로 보냈습니다.");
		}catch (MailException e) {
			System.out.println("에러 : " + e.getMessage());
		}
	}

	
	@SuppressWarnings("deprecation")
	public String getVelocityTemplateContent(Map<String, Object> model){
        StringBuffer content = new StringBuffer();
        try{
            content.append(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/vetemplates/velocity_mailTemplate.html","UTF-8", model));
        }catch(Exception e){
            System.out.println("Exception occured while processing velocity template:"+e.getMessage());
        }
        return content.toString();
    }
 
 
    public String getFreeMarkerTemplateContent(Map<String, Object> model){
        StringBuffer content = new StringBuffer();
        try{
         content.append(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate("fm_mailTemplate.html","UTF-8"), model));
        }catch(Exception e){
            System.out.println("Exception occured while processing fmtemplate:"+e.getMessage());
        }
        return content.toString();
    }
}
