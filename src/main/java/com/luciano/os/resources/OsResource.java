package com.luciano.os.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luciano.os.dtos.OsDTO;
import com.luciano.os.services.OsService;

@RestController
@RequestMapping(value = "/os")
public class OsResource {
	
	@Autowired
	private OsService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OsDTO> findById(@PathVariable Integer id) {
		OsDTO obj = new OsDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<OsDTO>> findAll() {
		List<OsDTO> list = service.findAll()
				.stream().map(obj -> new OsDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
}














