package br.com.desafio.netshoes.geradorevidencia.structures;

import java.util.LinkedList;

import com.itextpdf.text.Font;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.Statement;

public interface IConteudo {
	public void conjuntoPassos(String descricao);

	public void conjuntoPassos(String descricao, Font fonte);

	public void passo(String descricao);

	public void passo(String descricao, Font fonte);

	public void addTexto(String descricao);

	public void addTexto(String descricao, Font fonte);

	public void tirarPrintWeb() throws Exception;

	public void tirarPrintWeb(String descricao) throws Exception;

	public void tirarPrintWeb(String descricao, Font fonte) throws Exception;

	public void tirarPrintMobile() throws Exception;

	public void tirarPrintMobile(String descricao) throws Exception;

	public void tirarPrintMobile(String descricao, Font fonte) throws Exception;

	public LinkedList<Statement> getStatements();
}
