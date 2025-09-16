package br.com.cotiinformatica.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.enums.Prioridade;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ProdutoRepository {
	private ConnectionFactory connectionFactory = new ConnectionFactory();

	public void insert(Produto produto) {
		try {
			var connection = connectionFactory.getConnection();
			var sql = """
					insert into produto(id, nome, prioridade, preco, quantidade, categoria_id)
					values(?,?,?,?,?,?)
					""";
			var statement = connection.prepareStatement(sql);
			statement.setObject(1, produto.getId());
			statement.setString(2, produto.getNome());
			statement.setString(3, produto.getPrioridade().toString());
			statement.setDouble(4, produto.getPreco());
			statement.setInt(5, produto.getQuantidade());
			statement.setObject(6, produto.getCategoria().getId());
			statement.execute();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean update(Produto produto) {
		try {
			var connection = connectionFactory.getConnection();
			var sql = """
					update produto set nome = ?, prioridade = ?, preco = ?, quantidade = ?, categoria_id ? where id = ?
					""";
			var statement = connection.prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getPrioridade().toString());
			statement.setDouble(3, produto.getPreco());
			statement.setInt(4, produto.getQuantidade());
			statement.setObject(5, produto.getCategoria().getId());
			statement.setObject(6, produto.getId());
			var rowsAffected = statement.executeUpdate();
			connection.close();
			return rowsAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(UUID id) {
		try {
			var connection = connectionFactory.getConnection();

			var sql = """
					delete from produto
					where id = ?
					""";
			var statement = connection.prepareStatement(sql);
			statement.setObject(1, id);
			var rowsAffected = statement.executeUpdate();

			connection.close();
			return rowsAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Produto> findAll() {
		try {
			var connection = connectionFactory.getConnection();
			var sql = """
					select id, nome, preco, quantidade, prioridade, categoria_id
					from produto
					order by nome
					""";
			var statement = connection.prepareStatement(sql);
			var result = statement.executeQuery();
			var lista = new ArrayList<Produto>();

			while (result.next()) {
				
				var produto = new Produto();
				produto.setId(UUID.fromString(result.getString("id")));
				produto.setNome(result.getString("nome"));
				produto.setPreco(result.getDouble("preco"));
				produto.setPrioridade(Prioridade.valueOf(result.getString("prioridade")));
				produto.setQuantidade(result.getInt("quantidade"));
				lista.add(produto);
			}
			connection.close();
			return lista;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
