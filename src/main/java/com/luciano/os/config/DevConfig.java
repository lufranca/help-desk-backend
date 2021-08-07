package com.luciano.os.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luciano.os.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	
	public boolean instanciaDB() {
		
		if (ddl.equals("create")) {
			this.dbService.instanciaDB();
		}
		return false;
	}
}
