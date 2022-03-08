package kr.green.boot.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = "kr.green.boot")
@PropertySource("classpath:jdbc.properties")
public class AppConfig {
	@Value("${m.driver}")
	private String driverClass;
	@Value("${m.url}")
	private String url;
	@Value("${m.username}")
	private String username;
	@Value("${m.password}")
	private String password;
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.show_sql:false}")
	private String show_sql;
	@Value("${hibernate.format_sql:false}")
	private String format_sql;
	
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
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("kr.green.boot.vo");
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.show_sql", show_sql);
		properties.put("hibernate.format_sql", format_sql);
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
	}
	
	//@Bean
	public HibernateTransactionManager getHibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getLocalSessionFactoryBean().getObject());
		return transactionManager;
	}
}
