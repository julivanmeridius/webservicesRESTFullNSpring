/**
 * 
 */
package com.algaworks.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1869300553614629710L;

	public LivroNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public LivroNaoEncontradoException(String msg, Throwable causa) {
		super(msg, causa);
	}	
}