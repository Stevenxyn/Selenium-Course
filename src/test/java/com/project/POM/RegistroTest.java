package com.project.POM;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class RegistroTest {
	
	private WebDriver driver;
	paginaRegistro registerPage;

	@BeforeEach
	void setUp() throws Exception {
		registerPage = new paginaRegistro(driver);
		driver = registerPage.ChromeConexion();
		driver.get("https://demo.guru99.com/test/newtours/");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.print("Finalizo la prueba");


	}

	@Test
	void test() throws InterruptedException {
		registerPage.registroUsuario();
		assertEquals("Nombre usuario " ,registerPage.mensajeRegistro());
	}

}
