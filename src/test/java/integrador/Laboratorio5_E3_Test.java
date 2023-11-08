package integrador;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5_E3_Test {

	String url ="https://demo.guru99.com/test/table.html";
	WebDriver navegador;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..//EducacionIT//Drivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito"); 
		navegador = new ChromeDriver(options);
		navegador.get(url);
		navegador.manage().window().maximize();

	}
	
	@Test
	public void activarAlerta() {
		WebElement celda = navegador.findElement(By.xpath("//tbody/tr[4]/td[3]"));
		System.out.println(celda.getText());
	}
	@AfterSuite
	public void setDown() {
		navegador.close();
	}
}