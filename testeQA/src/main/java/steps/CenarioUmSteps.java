package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bean.Generic;
import bean.PaginaUtils;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import page.CenarioUmPage;

public class CenarioUmSteps {

	String mensagemDoErro = "";
	String textoRecuperado = "";
	WebDriver driver;
	CenarioUmPage cenarioUmPage = new CenarioUmPage();
	Generic generic = new Generic();
	PaginaUtils pgUtils = new PaginaUtils();

	@Dado("^clico no botao one$")
	public void clico_no_botao_one() throws Exception {

		try {
			Thread.sleep(2000);
			cenarioUmPage.clicarNoBotaoOne();
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}

	@Dado("^clico no botao two$")
	public void clico_no_botao_two() throws Exception {

		try {
			Thread.sleep(2000);
			cenarioUmPage.clicarNoBotaoTwo();
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}

	@Dado("^clico no botao four$")
	public void clico_no_botao_four() throws Exception {

		try {
			Thread.sleep(2000);
			cenarioUmPage.clicarNoBotaoFour();
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}

	@Entao("^devera exibir somente o botao three \"([^\"]*)\"$")
	public void devera_exibir_somente_o_botao_four(String three) throws Exception {

		try {
			Thread.sleep(1500);
			textoRecuperado = generic.recuperarTexto(cenarioUmPage.botaoThree);
			assertEquals(three, textoRecuperado);
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}

	@Dado("^devera clicar no botao one do iframe buttons$")
	public void devera_clicar_no_botao_one_do_iframe_buttons() throws Exception {

		try {
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement elemento = driver.findElement((cenarioUmPage.botaoOneFrameButtons));
			js.executeScript("arguments[0].click()", elemento);
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}

	@Dado("^devera clicar no botao two do iframe buttons$")
	public void devera_clicar_no_botao_two_do_iframe_buttons() throws Exception {

		try {
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement elemento = driver.findElement((cenarioUmPage.botaoTwoFrameButtons));
			js.executeScript("arguments[0].click()", elemento);
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}

	@Dado("^devera clicar no botao four do iframe buttons$")
	public void devera_clicar_no_botao_four_do_iframe_buttons() throws Exception {

		try {
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement elemento = driver.findElement((cenarioUmPage.botaoFourFrameButtons));
			js.executeScript("arguments[0].click()", elemento);
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}

	@Entao("^devera exibir somente o botao three \"([^\"]*)\" do iframe buttons$")
	public void devera_exibir_somente_o_botao_three_do_iframe_buttons(String threeIframeButton) throws Exception {

		try {
			Thread.sleep(3000);
			textoRecuperado = generic.recuperarTexto(cenarioUmPage.botaoThreeIframeButton);
			assertEquals(threeIframeButton, textoRecuperado);
			pgUtils.capturarScreenshot();
		} catch (NoSuchElementException e) {
			pgUtils.capturarScreenshot();
			mensagemDoErro = e.getMessage();
			System.setProperty("mensagemDoErro", mensagemDoErro);
			throw new NoSuchElementException(e.getMessage());
		}
	}

}