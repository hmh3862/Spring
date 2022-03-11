package kr.green.boot.service;

public interface MailService {

	void sendEmail();
    void sendEmail(String toAddress, String subject, String content);
    
}
