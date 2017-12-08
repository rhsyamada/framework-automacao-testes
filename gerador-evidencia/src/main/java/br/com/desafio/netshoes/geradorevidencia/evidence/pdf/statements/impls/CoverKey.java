package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.impls;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.Statement;

public class CoverKey extends Statement {
	public CoverKey(String descricao) {
		super(CoverKey.class);
		setDescription(descricao);
		setFont(FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, BaseColor.BLACK));
	}

	public CoverKey(String descricao, Integer colspan) {
		super(CoverKey.class);
		setDescription(descricao);
		setFont(FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, BaseColor.BLACK));
		setColspan(colspan);
	}
}
