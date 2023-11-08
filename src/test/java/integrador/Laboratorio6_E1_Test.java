package integrador;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio6_E1_Test {

	String url ="http://www.automationpractice.pl/index.php?";
	WebDriver driver; 
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..//EducacionIT//Drivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito"); 
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void buscarPalabra() {
		WebElement buscar = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		buscar.sendKeys("dress");
		buscar.sendKeys(Keys.ENTER);
	}
	@AfterSuite
	public void setDown() {
		driver.close();
	}
}