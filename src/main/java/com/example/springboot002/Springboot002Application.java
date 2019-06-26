package com.example.springboot002;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class Springboot002Application {

	public static void main(String[] args) {
		//SpringApplication.run(Springboot002Application.class, args);
		SpringApplication app = new SpringApplication(Springboot002Application.class);
		app.setBanner(new Banner() {
						  @Override
						  public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
						    out.print("\n  WOW Banner!!!\n \n");
						  }
					  }
		);
		app.run(args);
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setCacheSeconds(10); //reload messages every 10 seconds
		return messageSource;
	}
}
