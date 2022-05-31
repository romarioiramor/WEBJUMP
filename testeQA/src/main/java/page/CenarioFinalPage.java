package page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import config.DriverConfig;

public class CenarioFinalPage extends DriverConfig {

	public CenarioFinalPage() {
	}

	// MAPEAMENTOS
	public final By yuorFistName = By.xpath("//input[@id='first_name']");
	public final By selectOptionThree = By.xpath("//label[contains(.,'OptionThree')]");
	public final By selectExample = By.xpath("//select[@id='select_box']");
	public final By selectExampleTwo = By.xpath("/html/body/div/div[2]/div[1]/div/div[2]/select/option[2]");
	public final By img = By.xpath("//img[@alt='selenium']");
	
	
	
	// METODOS
	public void informarPrimeiroNome() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(yuorFistName).sendKeys(Keys.chord("Romário"));
	}
	
	public void selecionarOptionThree() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(selectOptionThree).click();
	}
	
	public void clicarEmExample() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(selectExample).click();
	}
	
	public void clickListaOptions() throws InterruptedException {
		Thread.sleep(700);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement elemento = driver.findElement(selectExampleTwo);
		js.executeScript("arguments[0].click()", elemento);
	}
	
	public void imagemExiste() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(img).getText();
	}
}
