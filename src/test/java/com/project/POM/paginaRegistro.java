package com.project.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class paginaRegistro extends Base {

	// Localizadores de la pagina de registro
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src ='images/mast_register.gif']");

	By userNameLocator = By.id("email");
	By passwordLocator = By.id("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");

	By registerBtnLocator = By.name("register");
	
	By registeredMessage = By.tagName("font");

	public paginaRegistro(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void registroUsuario() throws InterruptedException {
		click(registerLinkLocator);
		Thread.sleep(2000);
		if (esVisible(registerPageLocator)) {
			teclear("StevenLopez", userNameLocator);
			teclear("clave123", passwordLocator);
			teclear("clave123", confirmPasswordLocator);
			click(registerBtnLocator);
		} else {
			System.out.println("Elementos no encontrados revise che");
		}
	}

	public String mensajeRegistro() {
		java.util.List<WebElement> fonts = findElements(registeredMessage);
			return obtenerTexto(fonts.get(5));
		
	}

}
