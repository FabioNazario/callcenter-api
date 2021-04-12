package br.edu.infnet.callcenter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.infnet.callcenter.domain.Solucao;
import br.edu.infnet.callcenter.repositories.SolucaoRepository;

@Service
public class SolucaoService {
	
	
	@Autowired
	private SolucaoRepository repo;
	
	public Solucao find(Integer id) {
		
		Optional<Solucao> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
	
	public Solucao insert(Solucao obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Solucao update(Solucao obj) {
		
		if (find(obj.getId()) != null) {
			return repo.save(obj);
		}
		
		return null;

	}

	public Solucao delete(Integer id) {
		
		if (find(id)!= null) {
			repo.deleteById(id);
		}
		return null;
	}

	public List<Solucao> findAll() {
		
		return repo.findAll();
		
	}
	
}
