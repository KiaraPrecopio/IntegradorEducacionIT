package integrador;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio6_E2_Test {

	String url ="http://www.automationpractice.pl/index.php?";
	WebDriver driver; 
	String evidencias = "..//EducacionIT//Evidencias//";
	File captura;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..//EducacionIT//Drivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless"); 
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void buscarPalabra() throws IOException {
		capturaPantalla("pantallaInicial.jpg");
		WebElement buscar = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		buscar.sendKeys("dress");
		capturaPantalla("búsquedaVestido.jpg");
		buscar.sendKeys(Keys.ENTER);
		capturaPantalla("resultado.jpg");
	}
	public void capturaPantalla(String nombreArchivo) throws IOException {
		captura = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(captura, new File(evidencias + nombreArchivo + ".png"));
	}
	@AfterSuite
	public void setDown() {
		driver.close();
	}
}