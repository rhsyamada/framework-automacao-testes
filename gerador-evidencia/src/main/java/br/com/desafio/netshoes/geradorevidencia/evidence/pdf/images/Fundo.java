package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.images;

import com.itextpdf.text.Image;

import br.com.desafio.netshoes.geradorevidencia.GeradorEvidencia;

public class Fundo {
	private static Image img;

	private Fundo() {
		try {
			img = Image.getInstance(GeradorEvidencia.class.getResource("Fundo.jpg"));
			img.scaleToFit(350f, 350f);
			img.setAbsolutePosition(250f, 0f);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Image getImage() {
		if (img == null)
			new Fundo();

		return img;
	}
}
