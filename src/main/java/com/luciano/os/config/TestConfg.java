package com.luciano.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luciano.os.domain.services.DBService;

@Configuration
@Profile("test")
public class TestConfg {

	@Autowired
	private DBService dbService;

	@Bean
	public void instanciaBaseDeDados() {
		this.dbService.instanciaBaseDeDados();
	}

}
