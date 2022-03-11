package kr.green.boot.service;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
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
				mimeMessage.setFrom("itsungnam201111@gmail.com");// 보내는 사람 아이디
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("itsungnam201111@gmail.com"));// 받는 사람 아이디
				mimeMessage.setText("메일 내용입니다."); // 내용
				mimeMessage.setSubject("제목이란다."); // 제목
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
					mimeMessage.setFrom("itsungnam201111@gmail.com");// 보내는 사람 아이디
					mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));// 받는 사람 아이디
					mimeMessage.setSubject(subject); // 제목
					// mimeMessage.setText(content); // 텍스트로 보내기 
					
					// 내용 만들기 : HTML로 보내기!!!!					
					mimeMessage.setContent(content, "text/html;charset=UTF-8");
					/*
					Multipart multipart = new MimeMultipart();
					MimeBodyPart bodyPart = new MimeBodyPart();
					bodyPart.setContent(content, "text/html;charset=UTF-8");
					multipart.addBodyPart(bodyPart);
					mimeMessage.setContent(multipart); // 내용
					*/ 
				}
			});
			System.out.println("메일을 성공적으로 보냈습니다.");
		}catch (MailException e) {
			System.out.println("에러 : " + e.getMessage());
		}
		
	}

}
