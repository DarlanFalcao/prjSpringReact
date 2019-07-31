package br.com.desafiospring.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_produto")
public class Produto {
	@Column(name="idProduto")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idProduto;
	private String nome;
	private String descricao;
	private Date dataCadastro;
	private String imagem;
	public Long getIdProduto() {
		return idProduto;
	}
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	public Produto(String nome, String descricao,Date dataCadastro,String imagem) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.imagem = imagem;
	}
	
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
