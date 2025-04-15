import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class mercuryTours_AutomationTest {

	
//	Esto es el controlador que nos permitira interactuar con el navegador
//	en este caso WebDriver es el general sin especificar un navegador en concreto
	private WebDriver driver;
	
	//Localizadores
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src ='images/mast_register.gif']");

	By userNameLocator = By.id("email");
	By passwordLocator = By.id("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");

	By registerBtnLocator = By.name("register");
	
	
	@BeforeEach
	void setUp() throws Exception {
		//Setiamos la configuracion del entorno
		
		String pageHome = "https://demo.guru99.com/test/newtours/";
		
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromeDriver/chromedriver-win64/chromedriver.exe");
		
		//creamos la instancia
		driver = new ChromeDriver();
		
		//maximizamos la ventana
		driver.manage().window().maximize();
		
		//navegamos a la pagina
		driver.get(pageHome);
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
		System.out.println("Termino la prueba");
	}

	@Test
	void registerUser() throws InterruptedException {
		
		//Vamos a buscar el localizador, pero ya lo tenemos arriba mapeado
		driver.findElement(registerLinkLocator).click();
		
		//Damos un tiempo de espera para que cargue la pagina
		Thread.sleep(5000);
	}

}
