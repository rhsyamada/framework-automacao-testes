package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.impls;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.Statement;

public class CoverValue extends Statement {
	private static final Font FONTE = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);

	public CoverValue(String descricao) {
		super(CoverKey.class);
		setAttributes(descricao, null, FONTE);
	}

	public CoverValue(String descricao, Integer colspan) {
		super(CoverKey.class);
		setAttributes(descricao, colspan, FONTE);
	}

	public CoverValue(String descricao, Integer colspan, BaseColor color) {
		super(CoverKey.class);
		setAttributes(descricao, colspan, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, color));
	}

	private void setAttributes(String description, Integer colspan, Font font) {
		setDescription(description);
		setColspan(colspan);
		setFont(font);
	}
}
