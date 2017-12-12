package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.impls;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Rectangle;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.images.exceptions.ImageExceptions;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.Statement;

public class ItemPasso extends Statement {
	private static final Font FONTE = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);

	public ItemPasso(String descricao) {
		super(ItemPasso.class);
		setAttributes(descricao, FONTE);
	}

	public ItemPasso(String descricao, Font fonte) {
		super(ItemPasso.class);
		setAttributes(descricao, fonte);
	}

	public ItemPasso(byte[] imagem) throws ImageExceptions {
		super(ItemPasso.class);
		setAttributes(null, null, imagem);
	}
	
	public ItemPasso(String descricao, Font fonte, byte[] imagem) throws ImageExceptions {
		super(ItemPasso.class);
		setAttributes(descricao, fonte, imagem);
	}

	public ItemPasso(String descricao, byte[] imagem) throws ImageExceptions {
		super(ItemPasso.class);
		setAttributes(descricao, FONTE, imagem);
	}
	
	private void setAttributes(String descricao, Font fonte, byte[] imagem) throws ImageExceptions {
		setDescription(descricao);
		setFont(fonte);
		setImage(imagem);
		setBorder(Rectangle.NO_BORDER);
	}
	
	private void setAttributes(String descricao, Font fonte) {
		setDescription(descricao);
		setFont(fonte);
		setBorder(Rectangle.NO_BORDER);
	}
}
