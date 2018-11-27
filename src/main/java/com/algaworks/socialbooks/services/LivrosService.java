package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository; 
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Livro livro = livrosRepository.findOne(id);		
		if(livro == null) {
			throw new LivroNaoEncontradoException("O Livro: " + id + " Não Pode ser Encontrado!");
		}		
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.delete(id);	
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("Livro Não Pode Ser Encontrado!");
		}
	}

	public void atualizar(Livro livro) {
		try {
			verificarExistencia(livro.getId());
			livrosRepository.save(livro);			
		} catch (LivroNaoEncontradoException e) {
			throw new LivroNaoEncontradoException("Livro Não Pode Ser Encontrado!");
		}		
	}
	
	private void verificarExistencia(Long id) {
		buscar(id);
	}
}
