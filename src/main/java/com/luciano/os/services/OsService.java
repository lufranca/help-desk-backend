package com.luciano.os.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciano.os.domain.Cliente;
import com.luciano.os.domain.OS;
import com.luciano.os.domain.Tecnico;
import com.luciano.os.domain.enuns.Prioridade;
import com.luciano.os.domain.enuns.Status;
import com.luciano.os.dtos.OsDTO;
import com.luciano.os.repositories.OSRepository;
import com.luciano.os.services.exception.ObjectNotFoundException;

@Service
public class OsService {
	
	@Autowired
	private OSRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tecnico.class.getName()));
	}

	public List<OS> findAll() {
		return repository.findAll();
	}

	public OS create(OsDTO obj) {
		return repository.save(fromDTO(obj));
	}
	
	public OS update(Integer id, @Valid OsDTO obj) {
		obj.setId(id);
		OS oldObj = findById(id);
		oldObj = fromDTO(obj);
		return repository.save(oldObj);
	}
	
	private OS fromDTO(OsDTO obj) {
		
		Tecnico tec = tecnicoService.findById(obj.getTecnico());
		Cliente cli = clienteService.findById(obj.getCliente());
		
		OS newObj = new OS();
		
		if(obj.getId() != null) {
			newObj.setId(obj.getId());
		}
		
		if(obj.getStatus().equals(2)) {
			newObj.setDataFechamento(LocalDateTime.now());
		}
		
		newObj.setId(obj.getId());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		newObj.setStatus(Status.toEnum(obj.getStatus()));
		newObj.setTecnico(tec);
		newObj.setCliente(cli);
		
		return newObj;
	}



}




















