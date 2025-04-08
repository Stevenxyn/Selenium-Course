import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	private WebDriver driver;

	// Ajustamos el ambiente
	@Before
	public void setUp() {
		String locationDriver = "src/test/resources/chromeDriver/chromedriver-win64/chromedriver.exe";

		// Paginas
		String homeYoutube = "https://www.youtube.com/";

		System.setProperty("webdriver.chrome.driver", locationDriver);
		driver = new ChromeDriver();
		// Maximizar la ventana del chrome
		driver.manage().window().maximize();

		// Dar el Url al queremos ir
		driver.get(homeYoutube);
	}

	// aca estaran los pasos que queremos para ejecutar la prueba o pruebas
	@SuppressWarnings("deprecation")
	@Test
	public void testGooglePage() throws InterruptedException {
		// encontrar un elemento en la pagina
		WebElement searchBox = driver.findElement(By.name("search_query"));

		// Limpiamos cualquier texto que tenga la cajita
		searchBox.clear();

		// Enviamos el texto que queramos a la cajita
		searchBox.sendKeys("It’s grind season bro.");
		System.out.println("Acabas de ingresar el titulo del video en Youtube: It’s grind season bro.");

		// Con esto damos entes, bueno el robot de selenium jasdjas
		searchBox.submit();
		System.out.println("Acabas de buscar el video");

		// La clave es dar un tiempo de espera porque si se pone todo de corrido no
		// encuentra los elementos porque no han cargado
		Thread.sleep(5000);
		/*
		 * //un tiempo de espera para que la pagina cargue
		 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 * 
		 * assertEquals("It’s grind season bro.", driver.getTitle());
		 */

		By videoLocator = By.xpath(
				("//img[@src='https://i.ytimg.com/vi/xyWKAlCvC28/hq720.jpg?sqp=-oaymwEnCNAFEJQDSFryq4qpAxkIARUAAIhCGAHYAQHiAQoIGBACGAY4AUAB&rs=AOn4CLA2XWBcQtjo-8z8-ctWhuEWbhY6Tw']"));
		By videoLocator2 = By.linkText("RDK mentality");
		// WebElement selectVideo =
		// driver.findElement(By.xpath("//img[@src='https://i.ytimg.com/vi/xyWKAlCvC28/hq720.jpg?sqp=-oaymwEnCNAFEJQDSFryq4qpAxkIARUAAIhCGAHYAQHiAQoIGBACGAY4AUAB&rs=AOn4CLA2XWBcQtjo-8z8-ctWhuEWbhY6Tw']"));

		driver.findElement(videoLocator).click();
		System.out.println("Acabas de dar click en el video");

		Thread.sleep(5000);
		driver.navigate().refresh();
		System.out.println("Acabas de recargar la pagina despues de 5s");

		Thread.sleep(5000);
		driver.navigate().refresh();
		System.out.println("Acabas de recargar la pagina despues de 5s por segunda vez");
	}

	@After
	public void tearDown() {

		driver.quit();
		System.out.println("Las pruebas acabaron, se esta reproduciendo el video");

	}

}
