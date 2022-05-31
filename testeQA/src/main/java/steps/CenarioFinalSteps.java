package steps;

import org.openqa.selenium.NoSuchElementException;

import bean.Generic;
import bean.PaginaUtils;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import page.CenarioFinalPage;

public class CenarioFinalSteps {

	String mensagemDoErro = "";
	CenarioFinalPage cenarioFinal = new CenarioFinalPage();
	Generic generic = new Generic();
	PaginaUtils pgUtils = new PaginaUtils();
	
	
	@Dado("^que devera preencher o campo yourFirstName$")
	public void que_devera_preencher_o_campo_yourFirstName() throws Exception {
	    
		try {
			Thread.sleep(2000);
			cenarioFinal.informarPrimeiroNome();
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}

	@Dado("^devera selecionar a opcao optionThree$")
	public void devera_selecionar_a_opcao_optionThree() throws Exception {
	    
		try {
			Thread.sleep(1000);
			cenarioFinal.selecionarOptionThree();
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}

	@Dado("^devera selecionar a opcao exampleTwo$")
	public void devera_selecionar_a_opcao_exampleTwo() throws Exception {
	    
		try {
			Thread.sleep(1000);
			cenarioFinal.clicarEmExample();
			pgUtils.capturarScreenshot();
			Thread.sleep(1000);
			cenarioFinal.clickListaOptions();
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}

	@Entao("^devera exibir a logo do Selenium WebDriver$")
	public void devera_exibir_a_logo_do_Selenium_WebDriver() throws Exception {
	    
		try {
			Thread.sleep(2000);
			cenarioFinal.imagemExiste();
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
}
