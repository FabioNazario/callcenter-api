package br.edu.infnet.callcenter.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.callcenter.domain.Chamado;
import br.edu.infnet.callcenter.repositories.ChamadoRepository;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repo;
	
	public Chamado buscar(Integer id) {
		
		Optional<Chamado> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
}
