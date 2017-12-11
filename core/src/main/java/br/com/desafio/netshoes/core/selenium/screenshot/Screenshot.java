package br.com.desafio.netshoes.core.selenium.screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.desafio.netshoes.core.selenium.screenshot.impl.RunScreenshot;
import br.com.desafio.netshoes.core.selenium.screenshot.impl.UntilScreenShot;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Screenshot {
	public static byte[] take(WebDriver webDriver) {
		return new RunScreenshot().take(UntilScreenShot.screenShotWeb(webDriver));
	}
	
	public static byte[] take(WebDriver webDriver, WebElement... elements) {
		return new RunScreenshot().take(UntilScreenShot.screenShotWeb(webDriver, elements));
	}
	
	public static byte[] take(AppiumDriver<MobileElement> appiumDriver) {
		return new RunScreenshot().take(UntilScreenShot.screenShotMobile(appiumDriver));
	}
}
