package br.com.desafio.netshoes.geradorevidencia.structures;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.itextpdf.text.BaseColor;

import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.Statement;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.impls.CoverHeader;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.impls.CoverKey;
import br.com.desafio.netshoes.geradorevidencia.evidence.pdf.statements.impls.CoverValue;
import br.com.desafio.netshoes.geradorevidencia.structures.enums.StatusPasso;
import br.com.desafio.netshoes.geradorevidencia.structures.exceptions.StructureException;

public class Cabecalho {
	@NotNull
	@Pattern(regexp = "(.)+", message = "não informado.")
	private String idCt;
	@NotNull
	@Pattern(regexp = "(.)+", message = "não informado.")
	private String nomeCt;
	@NotNull
	@Pattern(regexp = "(.)+", message = "não informado.")
	private String objetivo;
	@NotNull
	@Pattern(regexp = "(.)+", message = "não informado.")
	private String cicloTeste;
	@NotNull
	@Pattern(regexp = "(.)+", message = "não informado.")
	private String nomeProjeto;
	@NotNull
	@Pattern(regexp = "(.)+", message = "não informado.")
	private String resultadoEsperado;
	@NotNull
	@Pattern(regexp = "(.)+", message = "não informado.")
	private String resultadoObtido;
	@NotNull
	@Pattern(regexp = "(.)+", message = "não informado.")
	private String ambiente;
	@NotNull
	@Pattern(regexp = "(.)+", message = "não informado.")
	private String nomeExecutor = "Automação";
	@NotNull
	private StatusPasso status = StatusPasso.Passed;

	private Date dataInicio = new Date();
	private Date dataFinal = new Date();

	public void setIdCt(String idCt) {
		this.idCt = idCt;
	}

	public void setNomeCt(String nomeCt) {
		this.nomeCt = nomeCt;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public void setCicloTeste(String cicloTeste) {
		this.cicloTeste = cicloTeste;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public void setResultadoEsperado(String resultadoEsperado) {
		this.resultadoEsperado = resultadoEsperado;
	}

	public void setResultadoObtido(String resultadoObtido) {
		this.resultadoObtido = resultadoObtido;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public void setNomeExecutor(String nomeExecutor) {
		this.nomeExecutor = nomeExecutor;
	}

	public void setStatus(StatusPasso status) {
		this.status = status;
	}

	private void validate() throws StructureException {
		try {
			Cabecalho info = this;
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

			Set<ConstraintViolation<Cabecalho>> violations = validator.validate(info);

			if (violations != null && !violations.isEmpty()) {
				StringBuilder stringBuilder = new StringBuilder(
						"Erro ao validar [" + info.getClass().getSimpleName() + "]");

				for (ConstraintViolation<Cabecalho> violation : violations) {
					stringBuilder.append(
							"\n          O campo: [" + violation.getPropertyPath() + "] " + violation.getMessage());
				}
				throw new StructureException(stringBuilder.toString());
			}
		} catch (Exception e) {
			throw new StructureException(e);
		}
	}

	public LinkedList<Statement> getStatements() throws StructureException {
		try {
			validate();
			LinkedList<Statement> statements = new LinkedList<>();

			// Cabecalho
			statements.add(new CoverHeader(nomeProjeto, 4));
			// Linha 1
			statements.add(new CoverKey("Ambiente"));
			statements.add(new CoverValue(ambiente));
			statements.add(new CoverKey("Data Teste"));
			statements.add(new CoverValue(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date())));
			// Linha 2
			statements.add(new CoverKey("Inicio Execução"));
			statements.add(new CoverValue(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataInicio)));
			statements.add(new CoverKey("Final Execução"));
			statements.add(new CoverValue(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataFinal)));
			// Linha 3
			statements.add(new CoverKey("ID + Nome CT"));
			statements.add(new CoverValue(idCt + " - " + nomeCt, 3));
			// Linha 4
			statements.add(new CoverKey("Objetivo"));
			statements.add(new CoverValue(objetivo, 3));
			// Linha 5
			statements.add(new CoverKey("Resultado Esperado"));
			statements.add(new CoverValue(resultadoEsperado, 3));
			// Linha 6
			statements.add(new CoverKey("Resultado Obtido"));
			statements.add(new CoverValue(resultadoObtido, 3));
			// Linha 7
			statements.add(new CoverKey("Status"));
			statements.add(new CoverValue(status.name(), 3,
					(status.equals(StatusPasso.Passed) ? BaseColor.GREEN : BaseColor.RED)));
			// Linha 8
			statements.add(new CoverKey("Nome Servidor"));
			statements.add(new CoverValue(InetAddress.getLocalHost().getHostName(), 3));
			// Linha 9
			statements.add(new CoverKey("Usuario Logado"));
			statements.add(new CoverValue(System.getProperty("user.name"), 3));
			// Linha 10
			statements.add(new CoverKey("Sistema Operacional"));
			statements.add(new CoverValue(System.getProperty("os.name")));
			statements.add(new CoverKey("Endereço IP"));
			statements.add(new CoverValue(InetAddress.getLocalHost().getHostAddress(), 3));
			return statements;
		} catch (Exception e) {
			throw new StructureException("Erro ao retornar o statement de cabeçalho.", e);
		}
	}
}
