package kr.green.boot.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "kr.green.boot")
@PropertySource("classpath:jdbc.properties")
@MapperScan(basePackages = {"kr.green.boot.dao"})
public class AppConfig {
	@Value("${m.driver}")
	private String driverClass;
	@Value("${m.url}")
	private String url;
	@Value("${m.username}")
	private String username;
	@Value("${m.password}")
	private String password;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Bean("dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sessionFactoryBean() throws IOException{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		// sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource(""));
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/kr/green/boot/dao/*.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("kr.green.boot.vo");
		return sqlSessionFactoryBean;
	}
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
