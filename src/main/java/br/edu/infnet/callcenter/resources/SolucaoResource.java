package br.edu.infnet.callcenter.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.callcenter.domain.Solucao;
import br.edu.infnet.callcenter.services.SolucaoService;

@RestController
@RequestMapping(value="/solucaos")
public class SolucaoResource {
	
	@Autowired
	private SolucaoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Solucao obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
