package br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.images.exceptions.ImageExceptions;

public class Statement {
	private Image image = null;
	private String description = null;
	private Font font = null;
	private Date date = new Date();
	private Integer colspan = null;
	private BaseColor backgroundColor = null;
	private Integer horizontalAlignment = Element.ALIGN_LEFT;
	private Integer verticalAlignment = Element.ALIGN_MIDDLE;
	private Integer border = Rectangle.BOX;
	private Class<? extends Statement> klass = null;

	public Statement(Class<? extends Statement> klass) {
		this.klass = klass;
	}

	public Image getImage() {
		return image;
	}

	public String getDescription() {
		return description;
	}

	public Font getFont() {
		return font;
	}

	public Date getDate() {
		return date;
	}

	public Integer getColspan() {
		return colspan;
	}

	public BaseColor getBackgroundColor() {
		return backgroundColor;
	}

	public Integer getHorizontalAlignment() {
		return horizontalAlignment;
	}

	public Integer getVerticalAlignment() {
		return verticalAlignment;
	}

	protected void setImage(byte[] image) throws ImageExceptions {
		try {
			this.image = Image.getInstance(image);
		} catch (Exception e) {
			throw new ImageExceptions("Erro ao carregar a imagem.", e);
		}
	}

	public void setDescription(String description) {
		this.description = description;
	}

	protected void setFont(Font font) {
		this.font = font;
	}

	protected void setColspan(Integer colspan) {
		this.colspan = colspan;
	}

	protected void setBackgroundColor(BaseColor backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	protected void setHorizontalAlignment(Integer horizontalAlignment) {
		this.horizontalAlignment = horizontalAlignment;
	}

	protected void setVerticalAlignment(Integer verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}

	public Class<? extends Statement> getKlass() {
		return klass;
	}

	public Boolean isFilled() {
		if (!StringUtils.isEmpty(description) || image != null)
			return true;
		else
			return false;
	}

	public Integer getBorder() {
		return border;
	}

	protected void setBorder(Integer border) {
		this.border = border;
	}
}
