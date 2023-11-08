package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class paginaInicio {
	//http://www.automationpractice.pl/index.php?
	WebDriver driver;
	@FindBy(partialLinkText="Sign")
	WebElement signIn;
	
	public paginaInicio(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory (driver,60), this);
	}
	
	public void clickSignIn () {
		signIn.click();
	}
	public String getTitulo() {
		return signIn.getText();
	}
}
