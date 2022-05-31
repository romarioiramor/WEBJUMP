package page;

import org.openqa.selenium.By;

import config.DriverConfig;

public class PaginaInicialPage extends DriverConfig {

	public PaginaInicialPage() {
	}

	// MAPEAMENTOS
	public final By img = By.xpath("//img[@class='center-block img-responsive']");

	// METODOS
	public void imgExiste() {
		driver.findElement(img).isDisplayed();
	}

	public void abrirBrowser(String paramNomeBrowser) {
		DriverConfig.selecionarBrowser(paramNomeBrowser);

	}
	
	public void abrirApp(String paramUrl) {
		DriverConfig.getURL(paramUrl);
	}
}
