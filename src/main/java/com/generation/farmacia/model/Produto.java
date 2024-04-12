package com.generation.farmacia.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo Nome é Obrigatório")
	@Size(min = 2, max = 200, message = "Tamanho mínimo: 3, Tamano máximo: 200")
	private String nome;
	
	@NotBlank(message = "O atributo Descrição é Obrigatório")
	@Size(min = 5, max = 1000, message = "Tamanho mínimo: 5, Tamano máximo: 1000")
	private String descricao;
	
	@NotNull(message = "O Atributo Quantidade é obrigatório")
	private int quantidade;

	@NotNull(message = "O Atributo Preço é obrigatório")
	@Column(precision = 8, scale = 2)
	private BigDecimal preco; 

	@NotNull(message = "Insira uma Imagem para seu produto" )
	private String foto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne // vários produtos N pode pertencer a 1 categoria (N:1)
	@JsonIgnoreProperties("produto") 
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}