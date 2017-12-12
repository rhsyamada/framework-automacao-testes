package br.com.desafio.netshoes.geradorevidencia.structures;

import java.util.LinkedList;

import org.openqa.selenium.WebDriver;

import com.itextpdf.text.Font;

import br.com.desafio.netshoes.core.selenium.screenshot.Screenshot;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.images.exceptions.ImageExceptions;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.Statement;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.impls.ConjuntoPassos;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.impls.ItemPasso;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.impls.Passo;

public class Evidencia {
	int numPasso = 1;
	LinkedList<Statement> statements = new LinkedList<>();

	public void conjuntoPassos(String descricao) {
		statements.add(new ConjuntoPassos(descricao));
	}

	public void conjuntoPassos(String descricao, Font fonte) {
		statements.add(new ConjuntoPassos(descricao, fonte));
	}

	public void passo(String descricao) {
		statements.add(new Passo(descricao));
	}

	public void passo(String descricao, Font fonte) {
		statements.add(new Passo(descricao, fonte));
	}

	public void addTexto(String descricao) {
		statements.add(new ItemPasso(descricao));
	}

	public void addTexto(String descricao, Font fonte) {
		statements.add(new ItemPasso(descricao, fonte));
	}

	public void tirarPrint(WebDriver driver) throws ImageExceptions {
		statements.add(new ItemPasso(Screenshot.take(driver)));
	}

	public void tirarPrint(WebDriver driver, String descricao) throws ImageExceptions {
		statements.add(new ItemPasso(descricao, Screenshot.take(driver)));
	}

	public void tirarPrint(WebDriver driver, String descricao, Font fonte) throws Exception {
		statements.add(new ItemPasso(descricao, fonte, Screenshot.take(driver)));
	}

	public LinkedList<Statement> getStatements() {
		statements.stream().filter(p -> p.getKlass().equals(Passo.class)).filter(p -> p.isFilled()).forEach(p -> {
			p.setDescription("Passo " + numPasso + " - " + p.getDescription());
			numPasso++;
		});
		return statements;
	}
}
