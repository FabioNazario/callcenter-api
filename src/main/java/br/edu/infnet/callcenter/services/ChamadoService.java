package br.edu.infnet.callcenter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.callcenter.domain.Chamado;
import br.edu.infnet.callcenter.repositories.ChamadoRepository;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repo;
	
	public List<Chamado> findAll() {
		
		return repo.findAll();
		
	}
	
	public Chamado find(Integer id) {
		
		Optional<Chamado> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
	
	public Chamado insert(Chamado obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Chamado update(Chamado obj) {
		
		if (find(obj.getId()) != null) {
			return repo.save(obj);
		}
		
		return null;

	}

	public Chamado delete(Integer id) {
		
		if (find(id)!= null) {
			repo.deleteById(id);
		}
		return null;
	}

}
