package kr.green.core.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("kr.green.core") // 지정 패키지를 읽어 자동으로 객체를 등록해라!!!
public class ApplicationConfig1 {

	@Bean("dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://localhost:3306/jspdb");
		dataSource.setUsername("jspuser");
		dataSource.setPassword("123456");
		return dataSource;
	}
	
}
