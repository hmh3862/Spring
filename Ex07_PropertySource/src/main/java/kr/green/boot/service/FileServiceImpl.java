package kr.green.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("fileService")
public class FileServiceImpl implements FileService {
	
	// Value 애노테이션은 프로퍼티 파일 안에 저장된 변수를 읽어서 주입시켜준다.
	// 변수가 있으면 주입시키고 없으면 기본값을 가진다.
	@Value("${sourceLocation:c:/temp/input}")
	private String source;
	
	@Value("${destinationLocation:c:/temp/output}")
	private String destination;
	
	@Autowired
	private Environment environment; // 환경 설정 객체
	
	// 자동주입
	@Value("${m.driver}")
	private String driverClass;
	@Value("${m.url}")
	private String url;
	@Value("${m.username}")
	private String username;
	@Value("${m.password}")
	private String password;
	@Value("#{config['jdbc.password']}") // #{아이디명['키']} util:properties로 읽을 경우
	private String password2;
	
	@Override
	public void readValues() {
		
		System.out.println("======================================================");
		System.out.println("사용자비번 : " + password2);
		System.out.println("======================================================");
		System.out.println("드라이버 클래스 이름 : " + environment.getProperty("jdbc.driverClassName"));
		System.out.println("URL : " + environment.getProperty("jdbc.url"));
		System.out.println("사용자이름 : " + environment.getProperty("jdbc.username"));
		System.out.println("사용자비번 : " + environment.getProperty("jdbc.password"));
		System.out.println("source : " + source);
		System.out.println("destination : " + destination);
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("드라이버 클래스 이름 : " + driverClass);
		System.out.println("URL : " + url);
		System.out.println("사용자이름 : " + username);
		System.out.println("사용자비번 : " + password);
	}

	@Override
	public String toString() {
		return "FileServiceImpl [source=" + source + ", destination=" + destination + ", environment=" + environment
				+ ", driverClass=" + driverClass + ", url=" + url + ", username=" + username + ", password=" + password
				+ "]";
	}
}
