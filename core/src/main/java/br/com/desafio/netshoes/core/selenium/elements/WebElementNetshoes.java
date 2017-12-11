package br.com.desafio.netshoes.core.selenium.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.internal.FindsByLinkText;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.internal.FindsByTagName;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.internal.HasIdentity;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.desafio.netshoes.core.selenium.command.WebCommand;

public class WebElementNetshoes extends RemoteWebElement
		implements WebElement, FindsByLinkText, FindsById, FindsByName, FindsByTagName, FindsByClassName,
		FindsByCssSelector, FindsByXPath, WrapsDriver, Locatable, HasIdentity, TakesScreenshot {
	private RemoteWebElement element;
	private WebCommand webCommand;

	public WebElementNetshoes(WebDriver driver, WebElement element) {
		this.element = (RemoteWebElement) element;
		webCommand = new WebCommand(driver);
		webCommand.waitProcessPage();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		webCommand.waitProcessPage();
		return element.getScreenshotAs(target);
	}

	@Override
	public void click() {
		webCommand.scrollIntoView(element);
		webCommand.until(ExpectedConditions.visibilityOf(element));
		element.click();
		webCommand.waitProcessPage();
	}

	@Override
	public void submit() {
		webCommand.scrollIntoView(element);
		webCommand.until(ExpectedConditions.visibilityOf(element));
		element.submit();
		webCommand.waitProcessPage();
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		webCommand.scrollIntoView(element);
		webCommand.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(keysToSend);
		webCommand.waitProcessPage();
	}

	@Override
	public void clear() {
		webCommand.scrollIntoView(element);
		webCommand.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		webCommand.waitProcessPage();
	}

	@Override
	public String getTagName() {
		webCommand.waitProcessPage();
		return element.getTagName();
	}

	@Override
	public String getAttribute(String name) {
		webCommand.waitProcessPage();
		return element.getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		webCommand.waitProcessPage();
		return element.isSelected();
	}

	@Override
	public boolean isEnabled() {
		webCommand.waitProcessPage();
		return element.isEnabled();
	}

	@Override
	public String getText() {
		webCommand.waitProcessPage();
		return element.getText();
	}

	@Override
	public List<WebElement> findElements(By by) {
		webCommand.waitProcessPage();
		return element.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		webCommand.waitProcessPage();
		return element.findElement(by);
	}

	@Override
	public boolean isDisplayed() {
		webCommand.waitProcessPage();
		return element.isDisplayed();
	}

	@Override
	public Point getLocation() {
		webCommand.waitProcessPage();
		return element.getLocation();
	}

	@Override
	public Dimension getSize() {
		webCommand.waitProcessPage();
		return element.getSize();
	}

	@Override
	public Rectangle getRect() {
		webCommand.waitProcessPage();
		return element.getRect();
	}

	@Override
	public String getCssValue(String propertyName) {
		webCommand.waitProcessPage();
		return element.getCssValue(propertyName);
	}

	@Override
	public String getId() {
		webCommand.waitProcessPage();
		return element.getId();
	}

	@Override
	public Coordinates getCoordinates() {
		webCommand.waitProcessPage();
		return element.getCoordinates();
	}

	@Override
	public WebDriver getWrappedDriver() {
		webCommand.waitProcessPage();
		return element.getWrappedDriver();
	}

	@Override
	public WebElement findElementByXPath(String using) {
		webCommand.waitProcessPage();
		return element.findElementByXPath(using);
	}

	@Override
	public List<WebElement> findElementsByXPath(String using) {
		webCommand.waitProcessPage();
		return element.findElementsByXPath(using);
	}

	@Override
	public WebElement findElementByCssSelector(String using) {
		webCommand.waitProcessPage();
		return element.findElementByCssSelector(using);
	}

	@Override
	public List<WebElement> findElementsByCssSelector(String using) {
		webCommand.waitProcessPage();
		return element.findElementsByCssSelector(using);
	}

	@Override
	public WebElement findElementByClassName(String using) {
		webCommand.waitProcessPage();
		return element.findElementByClassName(using);
	}

	@Override
	public List<WebElement> findElementsByClassName(String using) {
		webCommand.waitProcessPage();
		return element.findElementsByClassName(using);
	}

	@Override
	public WebElement findElementByTagName(String using) {
		webCommand.waitProcessPage();
		return element.findElementByTagName(using);
	}

	@Override
	public List<WebElement> findElementsByTagName(String using) {
		webCommand.waitProcessPage();
		return element.findElementsByTagName(using);
	}

	@Override
	public WebElement findElementByName(String using) {
		webCommand.waitProcessPage();
		return element.findElementByName(using);
	}

	@Override
	public List<WebElement> findElementsByName(String using) {
		webCommand.waitProcessPage();
		return element.findElementsByName(using);
	}

	@Override
	public WebElement findElementById(String using) {
		webCommand.waitProcessPage();
		return element.findElementById(using);
	}

	@Override
	public List<WebElement> findElementsById(String using) {
		webCommand.waitProcessPage();
		return element.findElementsById(using);
	}

	@Override
	public WebElement findElementByLinkText(String using) {
		webCommand.waitProcessPage();
		return element.findElementByLinkText(using);
	}

	@Override
	public List<WebElement> findElementsByLinkText(String using) {
		webCommand.waitProcessPage();
		return element.findElementsByLinkText(using);
	}

	@Override
	public WebElement findElementByPartialLinkText(String using) {
		webCommand.waitProcessPage();
		return element.findElementByPartialLinkText(using);
	}

	@Override
	public List<WebElement> findElementsByPartialLinkText(String using) {
		webCommand.waitProcessPage();
		return element.findElementsByPartialLinkText(using);
	}
}
