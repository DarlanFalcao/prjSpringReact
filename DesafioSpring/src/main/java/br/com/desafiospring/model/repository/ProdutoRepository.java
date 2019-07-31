package br.com.desafiospring.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.desafiospring.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	public Produto findByNome(String nome);
	public List<Produto>findAllByNome(String nome);
	
}
