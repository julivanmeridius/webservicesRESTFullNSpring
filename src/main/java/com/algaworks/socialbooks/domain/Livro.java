/**
 * 
 */
package com.algaworks.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Classe dominio de Livro.
 * @author Julivan Meridius
 */
@Entity
public class Livro {
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotEmpty(message = "O campo nome não pode ser vazio.")
	private String nome; 
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Campo publicação é de preechimento obrigatório.")
	private Date publicacao; 
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Campo editora é de preechimento obrigatório.")
	private String editora; 
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "O resumo de ver preenchido.")
	@Size(max = 1500, message = "O resumo não pode conter mais de 1500 caracteres.")
	private String resumo; 
	
	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios;
	
	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	@JsonInclude(Include.NON_NULL)
	private Autor autor;
	
	public Livro() {		
	}
	
	public Livro(String nomeLivro) {
		this.nome = nomeLivro;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the publicacao
	 */
	public Date getPublicacao() {
		return publicacao;
	}

	/**
	 * @param publicacao the publicacao to set
	 */
	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}

	/**
	 * @return the editora
	 */
	public String getEditora() {
		return editora;
	}

	/**
	 * @param editora the editora to set
	 */
	public void setEditora(String editora) {
		this.editora = editora;
	}

	/**
	 * @return the resumo
	 */
	public String getResumo() {
		return resumo;
	}

	/**
	 * @param resumo the resumo to set
	 */
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	/**
	 * @return the comentarios
	 */
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * @return the autor
	 */
	public Autor getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
