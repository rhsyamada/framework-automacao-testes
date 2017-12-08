package br.com.desafio.netshoes.core.selenium.command;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import br.com.desafio.netshoes.core.selenium.properties.PropertiesLoader;

public class WebCommand {
	private WebDriver driver;
	private int timeOut = Integer
			.parseInt(PropertiesLoader.getInstance().getValue("/application.properties", "app.web.driver.timeout"));

	public WebCommand(WebDriver driver) {
		this.driver = driver;
	}

	public Boolean exists(final String xpath, long timeWait) {
		try {
			ExpectedCondition<Boolean> waitStar = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					try {
						driver.findElement(By.xpath(xpath));
						return true;
					} catch (Exception e) {
						return false;
					}
				}
			};
			WebDriverWait tempWebDriverWait = new WebDriverWait(driver, timeWait);
			return tempWebDriverWait.until(waitStar);
		} catch (Exception e) {
			return false;
		}
	}
	
	public void moveToElement(WebElement element) {
		new Actions(driver)
		.moveToElement(element)
		.build().perform();
	}

	public void scrollIntoView(WebElement element) {
		int iniY = getCurrentScrollY();
		int finY = getWindowHeight();
		int positionY = getPositionY(element);

		if (!(positionY >= iniY && positionY <= finY)) {
			scrollTo(getPositionX(element), positionY);
		}
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public <V> V until(Function<? super WebDriver, V> isTrue) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
		return webDriverWait.until(isTrue);
	}

	public Boolean waitProcessPage() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
		return webDriverWait.until(waitProcessAngularJs()) && webDriverWait.until(waitProcessJQuery())
				&& webDriverWait.until(waitProcessJavaScript());
	}

	private ExpectedCondition<Boolean> waitProcessJQuery() {
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return Long.parseLong(
							((JavascriptExecutor) driver).executeScript("return jQuery.active").toString()) == 0;
				} catch (Exception e) {
					return true;
				}
			}
		};
		return jQueryLoad;
	}

	private ExpectedCondition<Boolean> waitProcessJavaScript() {
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		return jsLoad;
	}

	private ExpectedCondition<Boolean> waitProcessAngularJs() {
		ExpectedCondition<Boolean> AngularJsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					String js = "if (typeof angular !== 'undefined') {\r\n"
							+ "	return angular.element(document.body).injector().get('$http').pendingRequests.length;\r\n"
							+ "} else {return 0;}";
					return ((JavascriptExecutor) driver).executeScript(js).toString().equals("0");
				} catch (Exception e) {
					return true;
				}
			}
		};
		return AngularJsLoad;
	}

	public void clickJavaScript(WebElement element) {
		scrollIntoView(element);
		executeJs("arguments[0].click();", driver, element);
		waitProcessPage();
	}

	public int getFullHeight() {
		String pageHeightJs = "return Math.max(document.body.scrollHeight, document.body.offsetHeight, "
				+ "document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight);";
		return ((Number) executeJs(pageHeightJs, driver)).intValue();
	}

	public int getFullWidth() {
		String viewReportWidthJs = "return window.innerWidth || document.documentElement.clientWidth || document.getElementsByTagName('body')[0].clientWidth;";
		return ((Number) executeJs(viewReportWidthJs, driver)).intValue();
	}

	public int getWindowHeight() {
		String viewReportHeightJs = "return window.innerHeight || document.documentElement.clientHeight || document.getElementsByTagName('body')[0].clientHeight;";
		return ((Number) executeJs(viewReportHeightJs, driver)).intValue();
	}

	public int getCurrentScrollY() {
		return ((Number) executeJs("var scrY = window.scrollY; if(scrY){return scrY;} else {return 0;}", driver))
				.intValue();
	}

	public int getPositionY(WebElement element) {
		return ((Number) executeJs("return arguments[0].getBoundingClientRect().y;", driver, element)).intValue();
	}

	public int getPositionX(WebElement element) {
		return ((Number) executeJs("return arguments[0].getBoundingClientRect().x;", driver, element)).intValue();
	}

	public void scrollTo(int scrollX, int scrollY) {
		executeJs("scrollTo(arguments[0], arguments[1]); return [];", driver, scrollX, scrollY);
	}

	@SuppressWarnings("unchecked")
	private static <T> T executeJs(String script, WebDriver driver, Object... args) {
		try {
			return (T) ((JavascriptExecutor) driver).executeScript(script, args);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
