package br.com.desafio.netshoes.core.selenium.drivers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;

import br.com.desafio.netshoes.core.selenium.command.WebCommand;
import br.com.desafio.netshoes.core.selenium.elements.WebElementRede;
import br.com.desafio.netshoes.core.selenium.properties.PropertiesLoader;

public class WebDriverFirefox extends FirefoxDriver implements WebDriver {
	public WebDriverFirefox() {
		super();
	}

	public WebDriverFirefox(FirefoxProfile profile) {
		super(profile);
	}

	public WebDriverFirefox(Capabilities desiredCapabilities) {
		super(desiredCapabilities);
	}

	public WebDriverFirefox(Capabilities desiredCapabilities, Capabilities requiredCapabilities) {
		super(desiredCapabilities, requiredCapabilities);
	}

	public WebDriverFirefox(FirefoxBinary binary, FirefoxProfile profile) {
		super(binary, profile);
	}

	public WebDriverFirefox(FirefoxBinary binary, FirefoxProfile profile, Capabilities capabilities) {
		super(binary, profile, capabilities);
	}

	public WebDriverFirefox(FirefoxBinary binary, FirefoxProfile profile, Capabilities desiredCapabilities,
			Capabilities requiredCapabilities) {
		super(binary, profile, desiredCapabilities, requiredCapabilities);
	}

	public WebDriverFirefox(GeckoDriverService driverService, Capabilities desiredCapabilities,
			Capabilities requiredCapabilities) {
		super(driverService, desiredCapabilities, requiredCapabilities);
	}

	@Override
	public void get(String url) {
		super.get(url);
		new WebCommand(this).waitProcessPage();
	}

	@Override
	public List<WebElement> findElements(By by) {
		new WebCommand(this).waitProcessPage();
		List<WebElement> ret = new ArrayList<>();
		super.findElements(by).forEach(p -> ret.add(new WebElementRede(this, p)));
		return ret;
	}

	@Override
	public WebElement findElement(By by) {
		new WebCommand(this).waitProcessPage();
		return new WebElementRede(this, super.findElement(by));
	}

	public void resizeWebDriver() {
		Boolean maxime = getWindowMaxime();
		Integer width = getWindowWidth();
		Integer height = getWindowHeight();

		if (maxime != null && maxime) {
			this.manage().window().maximize();
		} else if (width != null && width > 0 && height != null && height > 0) {
			this.manage().window().setSize(new Dimension(width, height));
		}
	}

	private Boolean getWindowMaxime() {
		if (System.getProperty("app.web.driver.maximize") != null)
			return Boolean.parseBoolean(System.getProperty("app.web.driver.maximize"));
		else
			return Boolean.parseBoolean(
					PropertiesLoader.getInstance().getValue("/application.properties", "app.web.driver.maximize"));
	}

	private Integer getWindowWidth() {
		if (System.getProperty("app.web.driver.width") != null)
			return Integer.parseInt(System.getProperty("app.web.driver.width"));
		else
			return Integer.parseInt(
					PropertiesLoader.getInstance().getValue("/application.properties", "app.web.driver.width"));
	}

	private Integer getWindowHeight() {
		if (System.getProperty("app.web.driver.height") != null)
			return Integer.parseInt(System.getProperty("app.web.driver.height"));
		else
			return Integer.parseInt(
					PropertiesLoader.getInstance().getValue("/application.properties", "app.web.driver.height"));
	}
}
