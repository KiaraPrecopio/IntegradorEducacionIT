package integrador;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import org.testng.Assert;
import java.time.Duration;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static org.testng.Assert.assertEquals;

public class Laboratorio3_Test {

	String url = "http://www.automationpractice.pl";
	WebDriver navegador = new ChromeDriver();
	Faker fake = new Faker();
	String evidencias = "..//EducacionIT//Evidencias//";
	File captura;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..//EducacionIT//Drivers//chromedriver.exe");
	}

	@BeforeTest
	public void irURL() {
		navegador.get(url);
	}

	@BeforeClass
	public void maxVentana() {
		navegador.manage().deleteAllCookies();
		navegador.manage().window().maximize();
	}
	@BeforeMethod
	@Test
	public void registroUsuario() {
		// Declarando la espera de las acciones
		WebDriverWait navegadorwait = new WebDriverWait(navegador, Duration.ofSeconds(60));

		// Espera y click en Sign In
		navegadorwait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign")));
		navegador.findElement(By.partialLinkText("Sign")).click();

		// Espera y escritura de mail en casilla "EMAIL"
		navegadorwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email_create")));
		navegador.findElement(By.cssSelector("#email_create")).sendKeys(fake.internet().emailAddress());

		// click en "CREATE ACCOUNT"
		navegador.findElement(By.cssSelector("#SubmitCreate")).click();

		// Espera y escritura de primer nombre en casilla "FIRST NAME"
		navegadorwait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_firstname")));
		navegador.findElement(By.name("customer_firstname")).sendKeys(fake.name().firstName());

		// escritura de apellido en casilla "LAST NAME"
		navegador.findElement(By.id("customer_lastname")).sendKeys(fake.name().lastName());

		// escritura de contraseña en casilla "PASSWORD"
		navegador.findElement(By.id("passwd")).sendKeys(fake.internet().password());

		// Espera y selección de día de nacimiento en lista "DAYS"
		Select DayBirth = new Select(navegador.findElement(By.cssSelector("#days")));
		DayBirth.selectByValue("27");

		// Espera y selección de mes de nacimiento en lista "MONTHS"
		Select MonthBirth = new Select(navegador.findElement(By.cssSelector("#months")));
		MonthBirth.selectByValue("11");

		// Espera y selección de año de nacimiento en lista "YEARS"
		Select YearBirth = new Select(navegador.findElement(By.cssSelector("#years")));
		YearBirth.selectByValue("2002");

		// selección de radio button en "TITLE"
		navegador.findElement(By.id("id_gender2")).click();

		// click en REGISTRER
		navegador.findElement(By.id("submitAccount")).click();

		assertEquals(navegador.getTitle(), "My account - My Shop");
		Assert.assertTrue(true);
	}
	@AfterMethod
	public void evidencia() throws IOException {
		captura = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(captura, new File(evidencias + "Ultima Pantalla.jpg"));
	}
	@AfterClass
	public void finPrueba() {
		System.out.println("Fin de la prueba");
	}

	@AfterTest
	public void cierreNavegador() {
		navegador.close();
	}

	@AfterSuite
	public void finSuite() {
		System.out.println("Fin de pruebas totales");
	}
}
