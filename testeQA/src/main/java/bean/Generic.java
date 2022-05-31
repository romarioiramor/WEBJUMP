package bean;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import config.DriverConfig;

public class Generic extends DriverConfig{

	public String recuperarTexto(By paramElemento) throws InterruptedException {
		Thread.sleep(2000);
		String textoRecupado = driver.findElement(paramElemento).getText();
		return textoRecupado;
	}
	
	public void clickComJavaScriptLista(String paramXpath) throws InterruptedException {
		Thread.sleep(500);
		List<WebElement> my_list = driver.findElements(By.xpath("(//li[contains(@role,'option')])"));
		for (WebElement item : my_list) {
			if (item.getAttribute("innerHTML").contains(paramXpath)) {
				item.click();
				break;
			}
		}
	}
	
}
