package br.com.desafio.netshoes.geradorevidencia.tests;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

import br.com.desafio.netshoes.geradorevidencia.GeradorEvidencia;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.pages.exceptions.PageException;
import br.com.desafio.netshoes.geradorevidencia.structures.Cabecalho;
import br.com.desafio.netshoes.geradorevidencia.structures.Conteudo;
import br.com.desafio.netshoes.geradorevidencia.structures.enums.StatusPasso;

public class Teste {
	public static void main(String[] args) throws FileNotFoundException, PageException, DocumentException {
		GeradorEvidencia geradorEvidencia = new GeradorEvidencia();
		Cabecalho cabecalho = new Cabecalho();
		cabecalho.setAmbiente("091931");
		cabecalho.setCicloTeste("01");
		cabecalho.setIdCt("0123");
		cabecalho.setNomeCt("teste teste");
		cabecalho.setNomeExecutor("Automação");
		cabecalho.setNomeProjeto("teste teste teste");
		cabecalho.setObjetivo("objetivo");
		cabecalho.setResultadoEsperado("resultado esperado");
		cabecalho.setResultadoObtido("Resultado obtido");
		cabecalho.setStatus(StatusPasso.Passed);
		
		Conteudo conteudo = new Conteudo();
		conteudo.addTexto("Dlakdos");
		conteudo.addTexto("adada");
		geradorEvidencia.setContent(conteudo);
		geradorEvidencia.setCover(cabecalho);
		geradorEvidencia.save("teste");
	}
}
