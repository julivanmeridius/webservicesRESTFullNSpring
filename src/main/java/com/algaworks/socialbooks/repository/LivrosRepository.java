/**
 * 
 */
package com.algaworks.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialbooks.domain.Livro;

/**
 * Interface responsavel pelo CRUD de Livros.
 * @author Julivan Meridius
 */
public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
