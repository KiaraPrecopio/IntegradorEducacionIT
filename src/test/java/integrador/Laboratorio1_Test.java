package integrador;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Laboratorio1_Test {
	String url = "http://automationpractice.pl/";
	@Test
	public void lab1_test() {
		System.out.println("¡Hola mundo de automatización!");
	}

	@Test
	public void lab1_E1() {
		
		WebDriver navegador = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "..//EducacionIT//Drivers//chromedriver.exe");
		navegador.get(url);
		navegador.manage().window().maximize();
		navegador.navigate().refresh();
		navegador.close();

	}

	@Test
	public void lab1_E2() {
		WebDriver navegador = new FirefoxDriver();
		navegador.get(url);
		navegador.manage().window().maximize();
		navegador.close();
	}

	@Test
	public void lab1_E3() {
		
		WebDriver navegador = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "..//EducacionIT//Drivers//chromedriver.exe");
		navegador.get(url);
		WebElement txtBuscar = navegador.findElement(By.id("search_query_top"));
		txtBuscar.sendKeys("Dress");
		txtBuscar.sendKeys(Keys.ENTER);
		navegador.close();

	}
}
