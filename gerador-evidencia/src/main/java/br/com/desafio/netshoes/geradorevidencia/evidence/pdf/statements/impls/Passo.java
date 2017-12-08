package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.impls;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Rectangle;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.Statement;

public class Passo extends Statement {
	private static final Font FONTE = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);

	public Passo(String descricao) {
		super(Passo.class);
		setAttributes(descricao, FONTE);
	}

	public Passo(String descricao, Font fonte) {
		super(Passo.class);
		setAttributes(descricao, fonte);
	}

	private void setAttributes(String descricao, Font fonte) {
		setDescription(descricao);
		setFont(fonte);
		setBorder(Rectangle.NO_BORDER);
	}
}
