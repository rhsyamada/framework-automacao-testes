package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages;

import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages.exceptions.PageException;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.Statement;

public class PageBase {
	private PdfPTable table;
	private Document document;

	public PageBase(Document document, int numColumns) throws DocumentException {
		this.document = document;
		table = new PdfPTable(numColumns);
		table.setSplitLate(false);
		table.setWidthPercentage(100);
	}

	protected void addStatementToEvidencePdf(LinkedList<Statement> statements) throws PageException {
		try {
			statements.stream().filter(p -> p.isFilled()).forEach(p -> {
				addContent(p);
			});
			addTable(table);
		} catch (Exception e) {
			throw new PageException("Erro ao adicionar o Statement na evidencia PDF.", e);
		}
	}

	protected void addNewPage() throws PageException {
		try {
			openDocument();
			document.newPage();
		} catch (Exception e) {
			throw new PageException("Erro ao criar uma nova pagina na evidencia PDF.", e);
		}
	}

	private void addContent(Statement statement) {
		addText(statement);
		addImage(statement);
	}

	private void addText(Statement statement) {
		if (!StringUtils.isEmpty(statement.getDescription())) {
			PdfPCell cell = new PdfPCell(new Phrase(statement.getDescription(), statement.getFont()));
			cell.setPaddingBottom(10f);
			cell.setBorder(statement.getBorder());
			cell.setHorizontalAlignment(statement.getHorizontalAlignment());
			cell.setVerticalAlignment(statement.getVerticalAlignment());

			if (statement.getColspan() != null)
				cell.setColspan(statement.getColspan());

			if (statement.getBackgroundColor() != null)
				cell.setBackgroundColor(statement.getBackgroundColor());
			
			table.addCell(cell);
		}
	}
	
	public void addImage(Image image) throws DocumentException {
		openDocument();
		document.add(image);
	}

	private void addImage(Statement statement) {
		if (statement.getImage() != null) {
			try {
				Image image = Image.getInstance(statement.getImage());
				int percent = 100;
				if (image.getWidth() < 900)
					percent = 50;
				PdfPCell cell = new PdfPCell(image);
				image.scalePercent(((this.document.getPageSize().getWidth() - this.document.leftMargin()
						- this.document.rightMargin()) / image.getWidth()) * percent);
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setPaddingBottom(10f);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			} catch (Exception e) {
				// TODO colocar no log
			}
		}
	}

	private void openDocument() {
		if (!document.isOpen() == true) {
			document.open();
		}
	}

	private void addTable(PdfPTable table) throws PageException {
		try {
			openDocument();
			document.add(table);
		} catch (Exception e) {
			throw new PageException("Erro ao adicionar a tabela na evidencia PDF.", e);
		}
	}
}
