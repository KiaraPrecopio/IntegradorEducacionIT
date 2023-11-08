package paginas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaAlerta {
		// https://demoqa.com/alerts
		WebDriver driver;
		
		@FindBy(css="#promtButton")
		WebElement btnAlerta;		
		
		public paginaAlerta(WebDriver navegador) {
			PageFactory.initElements(navegador, this);
			driver = navegador;
		}		
		public void clickAlerta () {
			btnAlerta.click();
		}
		public Alert obtenerAlerta() {
			return driver.switchTo().alert();
		}
		public void escribirEnAlerta(Alert alerta, String palabra) {
			alerta.sendKeys(palabra);
		}
		public void hacerClicEnAceptar(Alert alerta) {
			alerta.accept();
		}
		public String obtenerTexto(Alert alerta) {
			return alerta.getText();
		}
}
