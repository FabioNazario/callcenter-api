package br.edu.infnet.callcenter.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.callcenter.domain.Defeito;
import br.edu.infnet.callcenter.repositories.DefeitoRepository;

@Service
public class DefeitoService {
	
	@Autowired
	private DefeitoRepository repo;
	
	public Defeito buscar(Integer id) {
		
		Optional<Defeito> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
}
