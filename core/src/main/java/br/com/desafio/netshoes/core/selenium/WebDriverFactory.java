package br.com.desafio.netshoes.core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.desafio.netshoes.core.selenium.enums.TypeWebDriver;
import br.com.desafio.netshoes.core.selenium.properties.PropertiesLoader;

public class WebDriverFactory {
	private final String APPLICATION_PROPERTIES = "/application.properties";

	private static WebDriverFactory instance = null;

	private WebDriverFactory() {
	}

	public static WebDriverFactory getInstance() {
		if (instance == null)
			instance = new WebDriverFactory();

		return instance;
	}

	public WebDriver createWebDriver(DesiredCapabilities capabilities) {
		String appWebDriver = "CHROME";
		if (System.getProperty("app.web.driver") != null) {
			appWebDriver = System.getProperty("app.web.driver");
		} else {
			appWebDriver = PropertiesLoader.getInstance().getValue(APPLICATION_PROPERTIES, "app.web.driver");
		}
		return TypeWebDriver.valueOf(appWebDriver).getWebDriver(capabilities);
	}

	public WebDriver createWebDriver() {
		String appWebDriver = "CHROME";
		if (System.getProperty("app.web.driver") != null) {
			appWebDriver = System.getProperty("app.web.driver");
		} else {
			appWebDriver = PropertiesLoader.getInstance().getValue(APPLICATION_PROPERTIES, "app.web.driver");
		}
		return TypeWebDriver.valueOf(appWebDriver).getWebDriver();
	}

	public WebDriver createWebDriver(TypeWebDriver type, DesiredCapabilities capabilities) {
		return type.getWebDriver(capabilities);
	}

	public WebDriver createWebDriver(TypeWebDriver type) {
		return type.getWebDriver();
	}
}
