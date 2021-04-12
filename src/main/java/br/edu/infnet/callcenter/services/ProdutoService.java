package br.edu.infnet.callcenter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.callcenter.domain.Produto;
import br.edu.infnet.callcenter.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto find(Integer id) {
		
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
	
	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Produto update(Produto obj) {
		
		if (find(obj.getId()) != null) {
			return repo.save(obj);
		}
		
		return null;

	}

	public Produto delete(Integer id) {
		
		if (find(id)!= null) {
			repo.deleteById(id);
		}
		return null;
	}

	public List<Produto> findAll() {
		
		return repo.findAll();
		
	}
}
