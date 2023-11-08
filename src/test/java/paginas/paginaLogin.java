package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class paginaLogin {
	WebDriver driver;
	@FindBy(tagName = "h1")
	WebElement title;
	@FindBy(css = "#email_create")
	WebElement emailRegistro;
	@FindBy(css = "#SubmitCreate")
	WebElement btnSubmit;
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[1]/a[1]")
	WebElement btnInicio;
	@FindBy(css = "#email")
	WebElement emailIngreso;
	@FindBy(css = "#passwd")
	WebElement password;
	@FindBy(css = "#SubmitLogin")
	WebElement btnIngreso;
	
	public paginaLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory (driver, 60), this);
	}
	public String getTituloForm() {
		return title.getText();
	}
	public void setEmail(String nEmail) {
		emailRegistro.sendKeys(nEmail);
	}
	public void clickSubmit () {
		btnSubmit.click();
	}
	public void goToInicio() {
		btnInicio.click();
	}
	public void setIngreso (String nEmail, String nPassword) {
		emailIngreso.sendKeys(nEmail);
		password.sendKeys(nPassword);
	}
	public void clickLogin() {
		btnIngreso.click();
	}
	
	
}
