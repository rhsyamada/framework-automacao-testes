package br.com.desafio.netshoes.geradorevidencia.evidence.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages.Content;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages.Cover;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages.Header;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages.exceptions.PageException;
import br.com.desafio.netshoes.geradorevidencia.structures.ICabecalho;
import br.com.desafio.netshoes.geradorevidencia.structures.IConteudo;

public class EvidencePdf {
	private Document document = new Document();
	private PdfWriter writer;

	private Content content;
	private Cover cover;

	public EvidencePdf(String nomeEvidencia) throws FileNotFoundException, DocumentException {
		String dirProperties = System.getProperty("dir.folder.evidence") != null
				? System.getProperty("dir.folder.evidence")
				: PropertiesLoader.getInstance().getValue("/application.properties", "dir.folder.evidence");
		String path = Paths.get(dirProperties, nomeEvidencia + ".pdf").toString();
		
		document.open();
		document.setMargins(20, 20, 80, 20);
		 createFolder(path);
		this.writer = PdfWriter.getInstance(document, new FileOutputStream(path));
		Header event = new Header();
		writer.setPageEvent(event);
		content = new Content(document);
		cover = new Cover(document);
		document.open();
	}

	public void createCover(ICabecalho cabecalho) throws PageException {
		cover.createCover(cabecalho);
	}

	public void createContent(IConteudo conteudo) throws PageException {
		content.createContent(conteudo);
	}

	public void save() {
		document.close();
	}

	private void createFolder(String path) {
		File file = new File(path);
		File directory = file.getParentFile();
		
		if (!directory.exists()) {
			directory.mkdir();
		}
	}
}
