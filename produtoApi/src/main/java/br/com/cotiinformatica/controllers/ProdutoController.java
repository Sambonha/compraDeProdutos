package br.com.cotiinformatica.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ProdutoPostRequest;
import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.enums.Prioridade;
import br.com.cotiinformatica.repositories.ProdutoRepository;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {

	private ProdutoRepository produtoRepository = new ProdutoRepository();

	@PostMapping
	public ResponseEntity<?> post(@RequestBody ProdutoPostRequest request) {
		

		var produto = new Produto();
		produto.setId(UUID.randomUUID());
		produto.setNome(request.getNomeProduto());
		produto.setPrioridade(Prioridade.valueOf(request.getPrioridadeProduto()));
		produto.setPreco(request.getPrecoProduto());
		produto.setQuantidade(request.getQuantidadeProduto());

		produto.setCategoria(new Categoria());
		produto.getCategoria().setId(UUID.fromString(request.getIdCategoria()));	
		
		
		produtoRepository.insert(produto);
		return ResponseEntity.ok("Produto cadastrado com sucesso!");
		

	}

	@PutMapping
	public ResponseEntity<?> put() {
		return ResponseEntity.ok("Sucesso!");
	}

	@DeleteMapping
	public ResponseEntity<?> delete() {
		return ResponseEntity.ok("Sucesso!");
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok("Sucesso!");
	}

}
