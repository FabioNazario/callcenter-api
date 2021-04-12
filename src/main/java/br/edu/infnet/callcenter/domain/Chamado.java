package br.edu.infnet.callcenter.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.infnet.callcenter.domain.enums.StatusAtendimento;
import br.edu.infnet.callcenter.domain.enums.ResultadoAtendimento;


@Entity
public class Chamado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataAbertura;

	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="defeito_id")
	private Defeito defeito;

	@ManyToOne
	@JoinColumn(name="solucao_id")
	private Solucao solucao;

	private Integer status;
	private Integer resultado;

	public Chamado() {
	}
	
	public Chamado(Defeito defeito, Solucao solucao) {
		super();
		this.dataAbertura = new Date();
		this.defeito = defeito;
		this.solucao = solucao;
		this.status = StatusAtendimento.NOVO.getCod();
		this.resultado = null;
	}
	
	public Chamado(Integer id, Date dataAbertura, Defeito defeito, Solucao solucao, Integer status, Integer resultado) {
		super();
		this.id = id;
		this.dataAbertura = dataAbertura;
		this.defeito = defeito;
		this.solucao = solucao;
		this.status = status;
		this.resultado = resultado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Defeito getDefeito() {
		return defeito;
	}

	public void setDefeito(Defeito defeito) {
		this.defeito = defeito;
	}

	public Solucao getSolucao() {
		return solucao;
	}

	public void setSolucao(Solucao solucao) {
		this.solucao = solucao;
	}
	
	
	public StatusAtendimento getStatus() {
		return StatusAtendimento.toEnum(status);
	}

	public void setStatus(StatusAtendimento status) {
		this.status = status.getCod();
	}
	
	public ResultadoAtendimento getResultado() {
		return ResultadoAtendimento.toEnum(resultado);
	}

	public void setResultado(ResultadoAtendimento resultado) {
		this.resultado = resultado.getCod();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}
