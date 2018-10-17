/**
 * 
 */
package com.algaworks.socialbooks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;

/**
 * Controller responsavel pelas atividades de livros.
 * @author Julivan Meridius
 */
@RestController
public class LivrosResources {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public List<Livro> listar() {
		return livrosRepository.findAll();
	}
}
