package br.edu.infnet.callcenter.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.callcenter.domain.Solucao;
import br.edu.infnet.callcenter.repositories.SolucaoRepository;

@Service
public class SolucaoService {
	
	@Autowired
	private SolucaoRepository repo;
	
	public Solucao buscar(Integer id) {
		
		Optional<Solucao> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
}
