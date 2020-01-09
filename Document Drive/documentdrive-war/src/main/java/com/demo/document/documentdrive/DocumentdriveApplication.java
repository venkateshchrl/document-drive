package com.demo.document.documentdrive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
@EnableConfigurationProperties(DocumentDriveServiceProperties.class)
public class DocumentdriveApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(DocumentdriveApplication.class, args);
	}
}
