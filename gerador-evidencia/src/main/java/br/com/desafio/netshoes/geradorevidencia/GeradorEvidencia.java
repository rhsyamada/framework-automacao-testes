package br.com.desafio.netshoes.geradorevidencia;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.EvidencePdf;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages.exceptions.PageException;
import br.com.desafio.netshoes.geradorevidencia.structures.Cabecalho;
import br.com.desafio.netshoes.geradorevidencia.structures.Evidencia;

public class GeradorEvidencia {
	private Evidencia content = new Evidencia();
	private Cabecalho cover = new Cabecalho();

	public void setContent(Evidencia content) {
		this.content = content;
	}

	public void setCover(Cabecalho cover) {
		this.cover = cover;
	}

	public void save(String nomeEvidencia) throws PageException, FileNotFoundException, DocumentException {
		EvidencePdf evidencePdf = new EvidencePdf(nomeEvidencia);
		evidencePdf.createCover(cover);
		evidencePdf.createContent(content);
		evidencePdf.save();
	}
}
