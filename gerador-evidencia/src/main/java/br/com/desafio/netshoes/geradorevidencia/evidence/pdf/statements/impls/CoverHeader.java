package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.impls;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.Statement;

public class CoverHeader extends Statement {
	private static final Font FONTE = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, BaseColor.WHITE);

	public CoverHeader(String descricao) {
		super(CoverHeader.class);
		setAttributes(descricao, null);
	}

	public CoverHeader(String descricao, Integer colspan) {
		super(CoverHeader.class);
		setAttributes(descricao, colspan);
	}

	private void setAttributes(String description, Integer colspan) {
		setDescription(description);
		setFont(FONTE);
		setColspan(colspan);
		setBackgroundColor(new BaseColor(90, 45, 130));
		setHorizontalAlignment(Element.ALIGN_CENTER);
		setVerticalAlignment(Element.ALIGN_MIDDLE);
	}
}
