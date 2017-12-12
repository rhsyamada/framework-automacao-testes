package br.com.desafio.netshoes.core.selenium.drivers;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.internal.FindsByLinkText;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.internal.FindsByTagName;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverProxy extends RemoteWebDriver implements WebDriver, JavascriptExecutor,
FindsById, FindsByClassName, FindsByLinkText, FindsByName,
FindsByCssSelector, FindsByTagName, FindsByXPath,
HasInputDevices, HasCapabilities, TakesScreenshot {
	private RemoteWebDriver driver = null;

	public void setDriver(WebDriver driver) {
		this.driver = (RemoteWebDriver)driver;
	}

	@Override
	public void get(String url) {
		driver.get(url);
	}

	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}

	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public void quit() {
		driver.quit();
	}

	@Override
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	@Override
	public Navigation navigate() {
		return driver.navigate();
	}

	@Override
	public Options manage() {
		return driver.manage();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return driver.getScreenshotAs(target);
	}

	@Override
	public Capabilities getCapabilities() {
		return driver.getCapabilities();
	}

	@Override
	public Keyboard getKeyboard() {
		return driver.getKeyboard();
	}

	@Override
	public Mouse getMouse() {
		return driver.getMouse();
	}

	@Override
	public WebElement findElementByXPath(String using) {
		return driver.findElementByXPath(using);
	}

	@Override
	public List<WebElement> findElementsByXPath(String using) {
		return driver.findElementsByXPath(using);
	}

	@Override
	public WebElement findElementByTagName(String using) {
		return driver.findElementByTagName(using);
	}

	@Override
	public List<WebElement> findElementsByTagName(String using) {
		return driver.findElementsByTagName(using);
	}

	@Override
	public WebElement findElementByCssSelector(String using) {
		return driver.findElementByCssSelector(using);
	}

	@Override
	public List<WebElement> findElementsByCssSelector(String using) {
		return driver.findElementsByCssSelector(using);
	}

	@Override
	public WebElement findElementByName(String using) {
		return driver.findElementByName(using);
	}

	@Override
	public List<WebElement> findElementsByName(String using) {
		return driver.findElementsByName(using);
	}

	@Override
	public WebElement findElementByLinkText(String using) {
		return driver.findElementByLinkText(using);
	}

	@Override
	public List<WebElement> findElementsByLinkText(String using) {
		return driver.findElementsByLinkText(using);
	}

	@Override
	public WebElement findElementByPartialLinkText(String using) {
		return driver.findElementByPartialLinkText(using);
	}

	@Override
	public List<WebElement> findElementsByPartialLinkText(String using) {
		return driver.findElementsByPartialLinkText(using);
	}

	@Override
	public WebElement findElementByClassName(String using) {
		return driver.findElementByClassName(using);
	}

	@Override
	public List<WebElement> findElementsByClassName(String using) {
		return driver.findElementsByClassName(using);
	}

	@Override
	public WebElement findElementById(String using) {
		return driver.findElementById(using);
	}

	@Override
	public List<WebElement> findElementsById(String using) {
		return driver.findElementsById(using);
	}

	@Override
	public Object executeScript(String script, Object... args) {
		return driver.executeScript(script, args);
	}

	@Override
	public Object executeAsyncScript(String script, Object... args) {
		return driver.executeAsyncScript(script, args);
	}

}
