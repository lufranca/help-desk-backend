package com.luciano.os;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luciano.os.domain.Cliente;
import com.luciano.os.domain.OS;
import com.luciano.os.domain.Tecnico;
import com.luciano.os.domain.enuns.Prioridade;
import com.luciano.os.domain.enuns.Status;
import com.luciano.os.repositories.ClienteRepository;
import com.luciano.os.repositories.OSRepository;
import com.luciano.os.repositories.TecnicoRepository;

@SpringBootApplication
public class OsApplication implements CommandLineRunner {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;

	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico t1 = new Tecnico(null, "Luciano", "052.073.819-54", "(41) 9505-9980");
		
		Cliente c1 = new Cliente(null, "Barbara", "065.716.929-37", "(41) 9857-7628");
		
		OS os1 = new OS(null, Prioridade.ALTA, "Teste 1", Status.ABERTO, t1, c1);
		
		t1.getList().add(os1);
		
		c1.getList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		
		osRepository.saveAll(Arrays.asList(os1));
		
	}
}








