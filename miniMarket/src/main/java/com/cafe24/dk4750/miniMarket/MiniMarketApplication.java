package com.cafe24.dk4750.miniMarket;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
@PropertySource("classpath:google.properties")
public class MiniMarketApplication {
	@Value( "${google.username}" )
	private String username;
	@Value( "${google.password}" )
	private String password;
	
	public static void main(String[] args) {
		SpringApplication.run(MiniMarketApplication.class, args);
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();//객체만듬 
		javaMailSender.setHost("smtp.gmail.com"); //메일 서버 이름 
		javaMailSender.setPort(587);
		System.out.println(username);
		System.out.println(password);
		javaMailSender.setUsername(username);
		javaMailSender.setPassword(password);
		
		Properties prop = new Properties(); //Properties == HashMap<String,String> 
		// 서버인증 받을건지
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.smtp.starttls.enable", "true");
		javaMailSender.setJavaMailProperties(prop);
		return javaMailSender;
	}
}
