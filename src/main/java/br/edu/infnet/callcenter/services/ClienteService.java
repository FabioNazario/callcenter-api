package br.edu.infnet.callcenter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.callcenter.domain.Cliente;
import br.edu.infnet.callcenter.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Cliente update(Cliente obj) {
		
		if (find(obj.getId()) != null) {
			return repo.save(obj);
		}
		
		return null;

	}

	public Cliente delete(Integer id) {
		
		if (find(id)!= null) {
			repo.deleteById(id);
		}
		return null;
	}

	public List<Cliente> findAll() {
		
		return repo.findAll();
		
	}
	
}
