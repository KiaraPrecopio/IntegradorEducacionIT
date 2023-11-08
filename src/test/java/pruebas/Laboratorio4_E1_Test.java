package pruebas;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.paginaInicio;
import paginas.paginaLogin;

public class Laboratorio4_E1_Test {

	String url ="http://www.automationpractice.pl/index.php?";
	WebDriver driver = new ChromeDriver();
	String evidencias = "..//EducacionIT//Evidencias//";
	File captura;
	paginaInicio inicio = new paginaInicio(driver);
	paginaLogin login = new paginaLogin(driver);
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..//EducacionIT//Drivers//chromedriver.exe");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@BeforeMethod
	public void irSignIn() {
		inicio.clickSignIn();
	}
	
	@Test(priority=0)
	public void irRegistroLogin() {
		Assert.assertEquals(login.getTituloForm(), "AUTHENTICATION");
	}
	
	@Test (priority=1)
	public void crearCuentaInvalida() throws IOException {
		login.setEmail(login.getTituloForm());	
		login.clickSubmit();
		Assert.assertEquals(login.getTituloForm(), "AUTHENTICATION");
		captura = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(captura, new File(evidencias + "Ultima Pantalla.jpg"));
	}
	
	@AfterMethod
	public void volverPagina() {
		login.goToInicio();
	}
	
	@AfterSuite
	public void setDown() {
		driver.close();
	}
}
