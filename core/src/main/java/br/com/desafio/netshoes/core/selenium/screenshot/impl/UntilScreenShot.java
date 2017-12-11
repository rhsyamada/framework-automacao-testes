package br.com.desafio.netshoes.core.selenium.screenshot.impl;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.desafio.netshoes.core.selenium.screenshot.interfaces.IScreenshot;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class UntilScreenShot {
	public static IScreenshot<byte[]> screenShotWeb(final WebDriver webdriver) {
		return new IScreenshot<byte[]>() {
			@Override
			public byte[] apply(Object input) {
				return ScrrenshotUtils.screenshot(webdriver);
			}
		};
	}

	public static IScreenshot<byte[]> screenShotWeb(final WebDriver webdriver, final WebElement... webElement) {
		return new IScreenshot<byte[]>() {
			@Override
			public byte[] apply(Object input) {
				String jsHighlight = ScrrenshotUtils.getJavaScriptHighlight(webdriver, webElement);
				String jsUnHighlight = ScrrenshotUtils.getJavaScriptUnHighlight(webdriver, webElement);
				ScrrenshotUtils.executeJavaScript(webdriver, jsHighlight, webElement);
				byte[] screenshot = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);
				ScrrenshotUtils.executeJavaScript(webdriver, jsUnHighlight, webElement);
				return screenshot;
			}
		};
	}
	
	public static IScreenshot<byte[]> screenShotMobile(final AppiumDriver<MobileElement> appiumdriver) {
		return new IScreenshot<byte[]>() {
			@Override
			public byte[] apply(Object input) {
				return ScrrenshotUtils.screenshot(appiumdriver);
			}
		};
	}
}
