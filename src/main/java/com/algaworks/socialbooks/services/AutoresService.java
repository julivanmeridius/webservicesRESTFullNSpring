package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.repository.AutoresRepository;
import com.algaworks.socialbooks.services.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
		
	public List<Autor> listar(){
		return autoresRepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Autor a = autoresRepository.findOne(autor.getId());
			if(a != null) {
				throw new AutorExistenteException("O Autor já existe!");
			}
		}
		return autoresRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Autor autor = autoresRepository.findOne(id);
		
		if(autor == null) {
			throw new AutorNaoEncontradoException("O Autor não pode ser encontrado!");
		}
		return autor;
	}
}
