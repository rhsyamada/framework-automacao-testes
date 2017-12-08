package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.images;

import com.itextpdf.text.Image;

import br.com.desafio.netshoes.geradorevidencia.GeradorEvidencia;

public class Banner {
	private static final Float SIZE_X = 550f;
	private static final Float SIZE_Y = 50f;
	private static Image img;

	private Banner() {
		try {
			img = Image.getInstance(GeradorEvidencia.class.getResource("Banner.jpg"));
			img.scaleToFit(SIZE_X, SIZE_Y);
		} catch (Exception e) {
			// TODO colocar log
		}
	}

	public static Image getImage() {
		if (img == null)
			new Banner();

		return img;
	}
}
