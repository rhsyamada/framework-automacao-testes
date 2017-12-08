package br.com.desafio.netshoes.geradorevidencia;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.EvidencePdf;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages.exceptions.PageException;
import br.com.desafio.netshoes.geradorevidencia.structures.Cabecalho;
import br.com.desafio.netshoes.geradorevidencia.structures.Conteudo;
import br.com.desafio.netshoes.geradorevidencia.structures.ICabecalho;
import br.com.desafio.netshoes.geradorevidencia.structures.IConteudo;

public class GeradorEvidencia {
	private IConteudo content = new Conteudo();
	private ICabecalho cover = new Cabecalho();

	public void setContent(IConteudo content) {
		this.content = content;
	}

	public void setCover(ICabecalho cover) {
		this.cover = cover;
	}

	public void save(String nomeEvidencia) throws PageException, FileNotFoundException, DocumentException {
		EvidencePdf evidencePdf = new EvidencePdf(nomeEvidencia);
		evidencePdf.createCover(cover);
		evidencePdf.createContent(content);
		evidencePdf.save();
	}
}
