package pruebas;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTest {
	WebDriver driver;
	String url ="http://www.automationpractice.pl/index.php?";
	String urlChrome = "C:\\Users\\kprec\\eclipse-workspace\\EducacionIT\\Drivers\\chromedriver.exe";
	String urlFirefox = "C:\\Users\\kprec\\eclipse-workspace\\EducacionIT\\Drivers\\geckodriver.exe";
	
	@BeforeMethod
	@Parameters ("navegador")
	public void setUp(@Optional("chrome") String navegador) {
		    if (navegador.equalsIgnoreCase("chrome")) {
		        System.setProperty("webdriver.chrome.driver", urlChrome);
		        driver = new ChromeDriver();
		    } else if (navegador.equalsIgnoreCase("firefox")) {
		        System.setProperty("webdriver.gecko.driver", urlFirefox);
		        driver = new FirefoxDriver();
		    }
		   driver.get(url);
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
	}
	
	@Test
	public void busquedaPagina() {
		driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
		driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.ENTER);
	}
	
	@AfterMethod
	public void setDown() {
		driver.close();
	}
	
	}