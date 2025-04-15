package com.project.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	private WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	// Ejecutable para crear una instancia del navegador Chrome
	public WebDriver ChromeConexion() {
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/chromeDriver/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	// Envolviendo los metodos comunes de selenium para estas pruebas
	public WebElement findElement(By localizador) {
		return driver.findElement(localizador);
	}

	// Devuelve la lista de elementos
	public List<WebElement> findElements(By localizador) {
		return driver.findElements(localizador);
	}

	// Devuelveme el texto del elemento que te pase
	public String obtenerTexto(WebElement element) {
		return element.getText();
	}

	// Devuelveme el texto del localizador que te pase
	public String obtenerTexto(By localizador) {
		return driver.findElement(localizador).getText();
	}

	// Para insertar texto a los campos de que necesitemos
	public void teclear(String inputText, By localizador) {
		driver.findElement(localizador).sendKeys(inputText);
	}

	// Para dar click a los elementos o botones etc..
	public void click(By localizador) {
		driver.findElement(localizador).click();
	}

	// Saber si el elemento esta listo para usarse
	public Boolean esVisible(By localizador) {
		try {
			driver.findElement(localizador).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
		return null;
	}

	// Metodo para recibir la URL de la pagina a automatizar
	public void visitar(String url) {
		driver.get(url);
	}

}
