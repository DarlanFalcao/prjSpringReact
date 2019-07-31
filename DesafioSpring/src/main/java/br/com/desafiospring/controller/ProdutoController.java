package br.com.desafiospring.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.desafiospring.model.Produto;
import br.com.desafiospring.model.repository.ProdutoRepository;

@Controller
@RequestMapping(path = "/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository prodRepository;

	public ProdutoController(ProdutoRepository repository) {

		this.prodRepository = repository;

	}

	@PostMapping(path = "/novo")
	@ResponseBody
	public Produto novoProduto(@RequestBody String produto) {
		
		Gson gson = new Gson();
		Produto prod = new Produto();
		prod = gson.fromJson(produto, Produto.class);
		prodRepository.save(prod);
		return prod;
	}

	@GetMapping
	@ResponseBody

	public List<Produto> listarProdutos() {

		return (List<Produto>) prodRepository.findAll();
	}
	@GetMapping(path ="/nome/{nome}")
	@ResponseBody
	public Produto buscarPorNome(@PathVariable String nome) {
		
	return prodRepository.findByNome(nome);
	}
	@GetMapping(path ="{id}")
	@ResponseBody
	public Optional<Produto> buscarPorId(@PathVariable Long id) {
		return prodRepository.findById(id);
	}

	@DeleteMapping(path ="{idProduto}")
	@ResponseBody
	public void deletarProduto(@PathVariable Long idProduto) {		
		prodRepository.delete(buscarPorId(idProduto).get());

	}
	@PutMapping
	@ResponseBody
	public void alterarProduto(@RequestParam Long id,String nome,String descricao,String imagem,Date dataCadastro) {
		Produto produto = new Produto(nome, descricao, new Date(), imagem);
		produto.setIdProduto(id);
		prodRepository.save(produto);
	}
	@GetMapping(path ="/buscaNome/{nome}")
	@ResponseBody
	public List<Produto> listarPorNome(@PathVariable String nome) {
		
	return prodRepository.findAllByNome(nome);
	}
}
