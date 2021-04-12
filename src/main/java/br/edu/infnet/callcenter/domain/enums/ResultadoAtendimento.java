package br.edu.infnet.callcenter.domain.enums;

public enum ResultadoAtendimento {
	
	CANCELADO(1, "Cancelado"),
	CONSERTADO(2, "Consertado"),
	SEM_SOLUCAO(3, "Sem Solução");
	
	private int cod;
	private String descricao;
	
	private ResultadoAtendimento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static ResultadoAtendimento toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (ResultadoAtendimento x : ResultadoAtendimento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}