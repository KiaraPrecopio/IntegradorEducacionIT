package integrador;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5_E1_Test {

	String url ="https://demo.guru99.com/test/upload/";
	WebDriver driver = new ChromeDriver();
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..//EducacionIT//Drivers//chromedriver.exe");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void adjuntarFile() {
		WebElement filAdjunto = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		filAdjunto.sendKeys("C:\\Users\\kprec\\eclipse-workspace\\EducacionIT\\adjuntos\\imagen.png");
		
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.id("submitbutton"));
	}
	@AfterSuite
	public void setDown() {
		driver.close();
	}
}




