package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import config.DriverConfig;

public class CenarioUmPage extends DriverConfig {


	// MAPEAMENTOS
	public final By botaoOne = By.xpath("//button[@id='btn_one']");
	public final By botaoTwo = By.xpath("//button[@id='btn_two']");
	public final By botaoThree = By.xpath("//button[@id='btn_three']");
	public final By linkFour = By.xpath("//button[@id='btn_link']");

	public final By botaoOneFrameButtons = By.xpath("(//button[@id='btn_one'])[1]");
	public final By botaoTwoFrameButtons = By.xpath("//button[@id='btn_two']");
	public final By botaoFourFrameButtons = By.xpath("//button[contains(.,'Four')]");
	public final By botaoThreeIframeButton = By.xpath("//button[@id='btn_three']");

	// METODOS
	public void clicarNoBotaoOne() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(botaoOne).click();
	}

	public void clicarNoBotaoTwo() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(botaoTwo).click();
	}

	public void clicarNoBotaoFour() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(linkFour).click();
	}

}
