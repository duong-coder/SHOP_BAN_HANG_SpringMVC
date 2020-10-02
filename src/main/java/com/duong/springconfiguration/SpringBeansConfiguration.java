package com.duong.springconfiguration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.duong.interceptor.CustomerLoginInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.duong")
@PropertySource(value = {"classpath:database.properties"})
@EnableTransactionManagement
public class SpringBeansConfiguration extends WebMvcConfigurerAdapter{
	@Autowired
	Environment environment;
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry handlerRegistry) {
		handlerRegistry
		.addResourceHandler("/static/**", "/imageProducts/**")
		.addResourceLocations("/resources/", "file:D:\\BuildAppJava\\ImageProducts\\");
//		handlerRegistry.addResourceHandler("/imageProducts/**")
//		.addResourceLocations("file:D:\\BuildAppJava\\ShopBanHang\\ImageProducts\\");
	}
	@Bean(name="multipartResolver")
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(-1);
		
		return commonsMultipartResolver;
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("mysql.driver"));
		dataSource.setUrl(environment.getProperty("mysql.url"));
		dataSource.setUsername(environment.getProperty("mysql.username"));
		dataSource.setPassword(environment.getProperty("mysql.password"));

		return dataSource;
	}
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(new String[] {"com.duong.entity"});
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		hibernateProperties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		
		sessionFactoryBean.setHibernateProperties(hibernateProperties);
		return sessionFactoryBean;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CustomerLoginInterceptor())
			.addPathPatterns("/order/cart");
	}
	
	@Bean(name="hibernateTransactionManager")
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		
		return hibernateTransactionManager;
	}
}
