package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.images.Banner;

public class Header extends PdfPageEventHelper {
	public void onEndPage(PdfWriter writer, Document document) {
		PdfContentByte cb = writer.getDirectContent();
		Phrase header = new Phrase(new Chunk(Banner.getImage(), 0, 0));
		ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, header,
				(document.right() - document.left()) / 2 + document.leftMargin(), document.top() + 10, 0);
	}
}
