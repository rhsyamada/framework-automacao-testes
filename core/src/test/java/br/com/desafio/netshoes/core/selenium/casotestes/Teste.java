package br.com.desafio.netshoes.core.selenium.casotestes;

import org.openqa.selenium.WebDriver;

import br.com.desafio.netshoes.core.selenium.WebDriverFactory;

public class Teste {
	public static void main(String[] args) {
		WebDriver driver = WebDriverFactory.getInstance().createWebDriver();
		driver.get("http://www.netshoes.com.br/");
		driver.close();
		driver.quit();
	}
}
