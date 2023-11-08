package pruebas;
import org.testng.Assert;
import org.testng.annotations.*;
import com.github.javafaker.Faker;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.paginaInicio;
import paginas.paginaLogin;

public class Laboratorio4_E2_Test {
	String url ="http://www.automationpractice.pl/index.php?";
	WebDriver driver = new ChromeDriver();
	String evidencias = "..//EducacionIT//Evidencias//";
	Faker fake = new Faker();
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
	@Test(dataProvider="Datos Login")
	public void inicioSesionInvalido(String nEmail, String nPassword) throws WebDriverException, IOException {
		login.setIngreso(nEmail, nPassword);
		login.clickLogin();
		
		Assert.assertEquals(login.getTituloForm(), "AUTHENTICATION");
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(evidencias + "Ultima Pantalla.jpg"));
	}
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatosLogin() {
		// Construir el arreglo bidimensional con los datos para probar el login
		Object[][] datos = new Object[1][2];
		datos[0][0] = fake.internet().emailAddress(); // correo
		datos[0][1] = fake.internet().password(); // contraseña
		return datos;
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
}
