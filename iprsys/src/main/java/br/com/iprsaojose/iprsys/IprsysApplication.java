package br.com.iprsaojose.iprsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class IprsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(IprsysApplication.class, args);
	}

}
