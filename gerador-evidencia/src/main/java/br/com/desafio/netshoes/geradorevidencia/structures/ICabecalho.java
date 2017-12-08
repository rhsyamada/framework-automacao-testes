package br.com.desafio.netshoes.geradorevidencia.structures;

import java.util.LinkedList;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.Statement;
import br.com.desafio.netshoes.geradorevidencia.structures.enums.StatusPasso;
import br.com.desafio.netshoes.geradorevidencia.structures.exceptions.StructureException;

public interface ICabecalho {
	public void setIdCt(String idCt);

	public void setNomeCt(String nomeCt);

	public void setObjetivo(String objetivo);

	public void setCicloTeste(String cicloTeste);

	public void setNomeProjeto(String nomeProjeto);

	public void setResultadoEsperado(String resultadoEsperado);

	public void setResultadoObtido(String resultadoObtido);

	public void setAmbiente(String ambiente);

	public void setNomeExecutor(String nomeExecutor);

	public void setStatus(StatusPasso status);

	public LinkedList<Statement> getStatements() throws StructureException;
}
