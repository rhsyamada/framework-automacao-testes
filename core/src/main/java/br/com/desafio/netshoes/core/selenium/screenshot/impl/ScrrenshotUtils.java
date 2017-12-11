package br.com.desafio.netshoes.core.selenium.screenshot.impl;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScrrenshotUtils {
	private final static String JS_HIGHLITH = "arguments[%d].setAttribute('style', 'border: 3px solid red!important');arguments[%d].focus();arguments[%d].scrollIntoView(true);";
	private final static String JS_UNDO = "arguments[%d].setAttribute('style', '%2$s');";
	
	public static byte[] screenshot(WebDriver webdriver) {
		return ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);
	}
	
	public static byte[] screenshot(AppiumDriver<MobileElement> appiumdriver) {
		return ((TakesScreenshot) appiumdriver).getScreenshotAs(OutputType.BYTES);
	}
	
	public static Object executeJavaScript(WebDriver webdriver, String javaScript, WebElement... webElement)  {
		JavascriptExecutor jse = ((JavascriptExecutor) webdriver);
		return jse.executeScript(javaScript, (Object[]) webElement);
	}
	
	public static String getJavaScriptHighlight(WebDriver webdriver, WebElement... webElement) {
		StringBuilder js = new StringBuilder();

		for (int i = 0; i < webElement.length; i++) {
			js.append(String.format(JS_HIGHLITH, i, i, i));
		}

		return js.toString();
	}

	public static String getJavaScriptUnHighlight(WebDriver webdriver, WebElement... webElement) {
		StringBuilder js = new StringBuilder();

		for (int i = 0; i < webElement.length; i++) {
			 js.append(String.format(JS_UNDO, i, webElement[i].getAttribute("style")));
		}
		return js.toString();
	}
}
