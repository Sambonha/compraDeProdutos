package br.com.cotiinformatica.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoPostRequest {
	
	
	private String nomeProduto;
	
	private Double precoProduto;
	
	private String prioridadeProduto;
	
	private Integer quantidadeProduto;
	
	private String idCategoria;

}
