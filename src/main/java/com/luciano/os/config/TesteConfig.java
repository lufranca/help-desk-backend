package com.luciano.os.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luciano.os.services.DBService;

@Configuration
@Profile("test")
public class TesteConfig {
	
	private DBService dbService;
	
	public void instanciaDB() {
		
		this.dbService.instanciaDB();
	}
}
