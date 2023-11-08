package integrador;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import java.time.Duration;

public class Laboratorio2_Test {
	@Test
	public void lab2_E1() {
		// Se declara una variable STRING para realizar un breakpoint
		// String url =
		// "http://automationpractice.com/index.php?controller=authentication#account-creation";

		// Declaración de página a testear
		String url = "http://www.automationpractice.pl";
		Faker fake = new Faker();
		
		// Seteando el WebDriver
		System.setProperty("webdriver.chrome.driver", "..//EducacionIT//Drivers//chromedriver.exe");
		WebDriver navegador = new ChromeDriver();

		// Inicializando la página, incluyendo la maximización
		navegador.get(url);
		navegador.manage().window().maximize();

		// Declarando la espera de las acciones
		WebDriverWait navegadorwait = new WebDriverWait(navegador, Duration.ofSeconds(30));

		// Espera y click en Sign In
		navegadorwait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")));
		navegador.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

		// Espera y escritura de mail en casilla "EMAIL"
		navegadorwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
		navegador.findElement(By.id("email_create")).sendKeys(fake.internet().emailAddress());// Espera y click en "CREATE ACCOUNT"
		navegadorwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"SubmitCreate\"]")));
		navegador.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();

		// Espera y escritura de primer nombre en casilla "FIRST NAME"
		navegadorwait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer_firstname")));
		navegador.findElement(By.name("customer_firstname")).sendKeys("Kiara");

		// Espera y escritura de apellido en casilla "LAST NAME"
		navegadorwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_lastname")));
		navegador.findElement(By.id("customer_lastname")).sendKeys("Precopio");

		// Espera y escritura de contraseña en casilla "PASSWORD"
		navegadorwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd")));
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

		// Espera y selección de género
		navegador.findElement(By.id("id_gender2")).click();
		
		
		// Espera y click en REGISTRER
		navegador.findElement(By.id("submitAccount")).click();

		// Se cierra el navegador
		navegador.close();
	}

}
