package kr.green.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("kr.green.core.vo") // 지정 패키지를 읽어 자동으로 객체를 등록해라!!!
public class ApplicationConfig1 {

}
