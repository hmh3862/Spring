package kr.green.boot.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;

	@Override
	public void sendEmail() {
		// 메일 보내기 준비하는 객체
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				helper.setFrom("itsungnam201111@gmail.com");// 보내는 사람 아이디
				helper.setTo("itsungnam201111@gmail.com");// 받는 사람 아이디
				helper.setSubject("제목이란다."); // 제목
				helper.setText("<h1>메일 내용입니다.<h1>", true); // 내용
				// 첨부 파일 추가
				helper.addAttachment("linux.png", new ClassPathResource("linux-icon.png"));
				helper.addAttachment("config.xml", new ClassPathResource("appConfig.xml"));
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
					
					String body = "<html><body><div>" + content + "</div>";
					body += "<img src='cid:logo'> <br><img src='cid:logo2'> <br>";
					body += "</body></html>";
					helper.setText(body, true);
					helper.addInline("logo", new ClassPathResource("linux-icon.png"));
					helper.addInline("logo2", new ClassPathResource("star.png"));
					
				}
			});
			System.out.println("메일을 성공적으로 보냈습니다.");
		}catch (MailException e) {
			System.out.println("에러 : " + e.getMessage());
		}
		
	}

}
