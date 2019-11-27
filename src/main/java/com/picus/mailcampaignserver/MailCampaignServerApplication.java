package com.picus.mailcampaignserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
public class MailCampaignServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailCampaignServerApplication.class, args);
	}

}
