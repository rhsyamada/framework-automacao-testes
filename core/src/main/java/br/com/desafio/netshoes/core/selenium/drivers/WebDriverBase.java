package br.com.desafio.netshoes.core.selenium.drivers;

import java.nio.file.Paths;

public class WebDriverBase {
	private String keyProperty;
	private String valueProperty;

	public WebDriverBase(String key, String value) {
		keyProperty = key;
		valueProperty = value;
	}

	public void setProperty() {
		if (System.getProperty(getKeyProperty()) == null)
			System.setProperty(getKeyProperty(), getValueProperty());
	}

	private String getKeyProperty() {
		return keyProperty;
	}

	private String getFileName() {
		String property = System.getProperty(keyProperty);
		String os = System.getProperty("os.name");

		if (property != null)
			return Paths.get(property).getFileName().toString();
		else {
			if (os.startsWith("Windows"))
				return valueProperty + ".exe";
			else
				return valueProperty;
		}
	}

	private String getValueProperty() {
		String property = System.getProperty(keyProperty);
		String os = System.getProperty("os.name");

		if (property != null)
			return Paths.get(property).toString();
		else {
			String sys = Paths.get("").toAbsolutePath().normalize().toString();
			sys += Paths.get("/src", "main", "resources", "drivers").toString() + "/";

			if (os.startsWith("Windows"))
				sys += "windows";
			else if (os.startsWith("Mac"))
				sys += "mac";
			else
				sys += "linux";

			return sys + "/" + getFileName();
		}
	}
}
