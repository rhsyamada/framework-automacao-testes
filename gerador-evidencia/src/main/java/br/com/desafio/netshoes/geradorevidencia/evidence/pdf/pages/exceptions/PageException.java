package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages.exceptions;

public class PageException  extends Exception {
	private static final long serialVersionUID = 1L;

	public PageException(String msg) {
		super(msg);
	}

	public PageException(Exception e) {
		super(e);
	}

	public PageException(String msg, Exception e) {
		super(msg, e);
	}
}