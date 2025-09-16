package br.com.cotiinformatica.entities;

import java.util.UUID;

import br.com.cotiinformatica.enums.Prioridade;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Produto {
	private UUID id;
	private String nome;
	private Double preco;
	private Integer quantidade;
	private Prioridade prioridade;
	private Categoria categoria;
	

}
