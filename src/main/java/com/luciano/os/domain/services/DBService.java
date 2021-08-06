package com.luciano.os.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciano.os.domain.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	public void instanciaBaseDeDados() {

	}
}
