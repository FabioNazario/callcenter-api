package br.edu.infnet.callcenter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.callcenter.domain.Defeito;
import br.edu.infnet.callcenter.repositories.DefeitoRepository;

@Service
public class DefeitoService {
	
	@Autowired
	private DefeitoRepository repo;
	
	public Defeito find(Integer id) {
		
		Optional<Defeito> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
	
	public Defeito insert(Defeito obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Defeito update(Defeito obj) {
		
		if (find(obj.getId()) != null) {
			return repo.save(obj);
		}
		
		return null;

	}

	public Defeito delete(Integer id) {
		
		if (find(id)!= null) {
			repo.deleteById(id);
		}
		return null;
	}

	public List<Defeito> findAll() {
		
		return repo.findAll();
		
	}
}
