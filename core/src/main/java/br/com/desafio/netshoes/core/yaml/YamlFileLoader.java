package br.com.desafio.netshoes.core.yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;


public class YamlFileLoader {

	public static Object getAttribute(String path, String... param) throws Exception {

		File file = new File(path);
		InputStream input = new FileInputStream(file);
		Yaml yaml = new Yaml();

		Map<?, ?> mapAux = (Map<?, ?>) yaml.load(input);

		if (mapAux == null) {
			throw new Exception(
					String.format("A massa de dados não foi localizada no arquivo %s", file.getName()));
		}

		int cont;

		for (cont = 0; cont < (param.length - 1); cont++) {
			mapAux = (Map<?, ?>) mapAux.get(param[cont]);
		}

		return mapAux.get(param[cont]);
	}
}