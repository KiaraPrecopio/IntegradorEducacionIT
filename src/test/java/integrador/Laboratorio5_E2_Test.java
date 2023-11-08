package integrador;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import paginas.paginaAlerta;

public class Laboratorio5_E2_Test {

	String url ="https://demoqa.com/alerts";
	WebDriver navegador;
	paginaAlerta alerta;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..//EducacionIT//Drivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito"); 
		navegador = new ChromeDriver(options);
		navegador.get(url);
		navegador.manage().window().maximize();
		alerta = new paginaAlerta(navegador);
	
	}
	
	@Test
	public void activarAlerta() {
		alerta.clickAlerta();
		alerta.obtenerAlerta();
		alerta.escribirEnAlerta(alerta.obtenerAlerta(), "palabra");
		alerta.hacerClicEnAceptar(alerta.obtenerAlerta());
	}
	@AfterSuite
	public void setDown() {
		navegador.close();
	}
}

/*public void clickAlerta () {
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
}*/