package br.edu.infnet.callcenter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.callcenter.domain.Defeito;

@Repository
public interface DefeitoRepository extends JpaRepository<Defeito, Integer> {
	
}
