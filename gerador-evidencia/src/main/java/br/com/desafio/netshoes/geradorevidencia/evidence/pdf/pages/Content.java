package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages.exceptions.PageException;
import br.com.desafio.netshoes.geradorevidencia.structures.Evidencia;

public class Content extends PageBase {
	public Content(Document document) throws DocumentException {
		super(document, 1);
	}

	public void createContent(Evidencia conteudo) throws PageException {
		try {
			addNewPage();
			addStatementToEvidencePdf(conteudo.getStatements());
		} catch (Exception e) {
			throw new PageException("Erro ao adicionar o conteudo na evidencia PDF.", e);
		}
	}
}
