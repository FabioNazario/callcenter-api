package br.edu.infnet.callcenter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.callcenter.domain.Solucao;

@Repository
public interface SolucaoRepository extends JpaRepository<Solucao, Integer> {
	
}
