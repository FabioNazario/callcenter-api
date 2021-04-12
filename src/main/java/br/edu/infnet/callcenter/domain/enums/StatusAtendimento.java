package br.edu.infnet.callcenter.domain.enums;

public enum StatusAtendimento {
	
	NOVO(1, "Novo"),
	EM_ANDAMENTO(2, "Em Andamento"),
	FINALIZADO(3, "Finalizado");
	
	private int cod;
	private String descricao;
	
	private StatusAtendimento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static StatusAtendimento toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (StatusAtendimento x : StatusAtendimento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}


