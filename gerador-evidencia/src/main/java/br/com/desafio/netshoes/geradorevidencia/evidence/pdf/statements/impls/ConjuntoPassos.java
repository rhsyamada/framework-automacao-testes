package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.impls;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Rectangle;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.Statement;

public class ConjuntoPassos extends Statement {
	private static final Font FONTE = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);

	public ConjuntoPassos(String descricao) {
		super(ConjuntoPassos.class);
		setAttributes(descricao, FONTE);
	}

	public ConjuntoPassos(String descricao, Font fonte) {
		super(ConjuntoPassos.class);
		setAttributes(descricao, fonte);
	}

	private void setAttributes(String descricao, Font fonte) {
		setDescription(descricao);
		setFont(fonte);
		setHorizontalAlignment(Element.ALIGN_CENTER);
		setBorder(Rectangle.NO_BORDER);
	}
}
