package br.edu.infnet.callcenter.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.callcenter.domain.Defeito;
import br.edu.infnet.callcenter.services.DefeitoService;

@RestController
@RequestMapping(value="/defeitos")
public class DefeitoResource {
	
	@Autowired
	private DefeitoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Defeito obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
