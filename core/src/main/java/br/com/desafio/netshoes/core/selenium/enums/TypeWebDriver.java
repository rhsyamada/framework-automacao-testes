package br.com.desafio.netshoes.core.selenium.enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.desafio.netshoes.core.selenium.drivers.WebDriverBase;
import br.com.desafio.netshoes.core.selenium.drivers.WebDriverChrome;
import br.com.desafio.netshoes.core.selenium.drivers.WebDriverFirefox;
import br.com.desafio.netshoes.core.selenium.drivers.WebDriverInternetExplorer;

public enum TypeWebDriver {
	INTERNET_EXPLORER {
		private String key = "webdriver.ie.driver";
		private String value = "IEDriverServer";

		@Override
		public WebDriver getWebDriver() {
			new WebDriverBase(key, value).setProperty();
			WebDriverInternetExplorer driver = new WebDriverInternetExplorer();
			driver.resizeWebDriver();
			return driver;
		}

		@Override
		public WebDriver getWebDriver(DesiredCapabilities capabilities) {
			new WebDriverBase(key, value).setProperty();
			WebDriverInternetExplorer driver = new WebDriverInternetExplorer(capabilities);
			driver.resizeWebDriver();
			return driver;
		}
	},
	FIREFOX {
		private String key = "webdriver.gecko.driver";
		private String value = "geckodriver";

		@Override
		public WebDriver getWebDriver() {
			new WebDriverBase(key, value).setProperty();
			WebDriverFirefox driver = new WebDriverFirefox();
			driver.resizeWebDriver();
			return driver;
		}

		@Override
		public WebDriver getWebDriver(DesiredCapabilities capabilities) {
			new WebDriverBase(key, value).setProperty();
			WebDriverFirefox driver = new WebDriverFirefox(capabilities);
			driver.resizeWebDriver();
			return driver;
		}
	},
	CHROME {
		private String key = "webdriver.chrome.driver";
		private String value = "chromedriver";

		@Override
		public WebDriver getWebDriver() {
			new WebDriverBase(key, value).setProperty();
			WebDriverChrome driver = new WebDriverChrome();
			driver.resizeWebDriver();
			return driver;
		}

		@Override
		public WebDriver getWebDriver(DesiredCapabilities capabilities) {
			new WebDriverBase(key, value).setProperty();
			WebDriverChrome driver = new WebDriverChrome(capabilities);
			driver.resizeWebDriver();
			return driver;
		}
	};

	public abstract WebDriver getWebDriver();

	public abstract WebDriver getWebDriver(DesiredCapabilities capabilities);
}
