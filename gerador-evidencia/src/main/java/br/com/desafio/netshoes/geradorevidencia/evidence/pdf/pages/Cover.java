package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.images.Fundo;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages.exceptions.PageException;
import br.com.desafio.netshoes.geradorevidencia.structures.ICabecalho;

public class Cover extends PageBase {
	public Cover(Document document) throws DocumentException {
		super(document, 4);
	}

	public void createCover(ICabecalho cabecalho) throws PageException {
		try {
			addStatementToEvidencePdf(cabecalho.getStatements());
			addImage(Fundo.getImage());
		} catch (Exception e) {
			throw new PageException("Erro ao adicionar a capa na evidencia PDF.", e);
		}
	}
}
