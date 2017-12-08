package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.images.exceptions;

public class ImageExceptions extends Exception {
	private static final long serialVersionUID = 1L;

	public ImageExceptions(String msg) {
		super(msg);
	}
	
	public ImageExceptions(Exception e) {
		super(e);
	}
	
	public ImageExceptions(String msg, Exception e) {
		super(msg, e);
	}
}
