package br.com.desafio.netshoes.geradorevidencia.structures.exceptions;

public class StructureException extends Exception {
	private static final long serialVersionUID = 1L;

	public StructureException(String msg) {
		super(msg);
	}

	public StructureException(Exception e) {
		super(e);
	}

	public StructureException(String msg, Exception e) {
		super(msg, e);
	}
}