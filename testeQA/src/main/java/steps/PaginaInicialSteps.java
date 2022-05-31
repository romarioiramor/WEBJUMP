package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import bean.Generic;
import bean.PaginaUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import page.PaginaInicialPage;

public class PaginaInicialSteps {

	String mensagemDoErro = "";
	String imgRecuperado = "";
	String url = "https://wj-qa-automation-test.github.io/qa-test/";
	WebDriver driver;
	
	Generic generic = new Generic();
	PaginaInicialPage paginaInicial = new PaginaInicialPage();
	PaginaUtils pgUtils = new PaginaUtils();
		
	@Dado("^que eu entro no site de teste para a vaga de qa$")
	public void que_eu_entro_no_site_de_teste_para_a_vaga_de_qa() throws Exception {

		try {
			Thread.sleep(1000);
			paginaInicial.abrirBrowser("firefox");
			pgUtils.capturarScreenshot();
			Thread.sleep(1000);
			paginaInicial.abrirApp(url);
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
	@Entao("^devera exibir a imagem webjump$")
	public void devera_exibir_a_imagem_webjump() throws Exception {
	    
		try {
			Thread.sleep(3000);
			paginaInicial.imgExiste();
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}
}
