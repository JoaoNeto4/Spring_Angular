package com.example.algamoney.api.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class LancamentoFilter {

	
	private String descricao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVenciementoDe;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVencimentoAte;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataVenciementoDe() {
		return dataVenciementoDe;
	}
	public void setDataVenciementoDe(LocalDate dataVenciementoDe) {
		this.dataVenciementoDe = dataVenciementoDe;
	}
	public LocalDate getDataVencimentoAte() {
		return dataVencimentoAte;
	}
	public void setDataVencimentoAte(LocalDate dataVencimentoAte) {
		this.dataVencimentoAte = dataVencimentoAte;
	}
	
}
