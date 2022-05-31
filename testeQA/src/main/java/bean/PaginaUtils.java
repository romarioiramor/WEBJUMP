package bean;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import config.DriverConfig;
import cucumber.api.Scenario;
import io.qameta.allure.Allure;

public class PaginaUtils extends DriverConfig {

	public PaginaUtils() {
		super();
	}

	public static String getNomeFeature(Scenario cenario) {
		Matcher m = Pattern.compile("[\\w]+\\.feature").matcher(cenario.getId());
		if (m.find()) {
			return m.group(0).replace(".feature", "");
		} else {
			throw new IllegalStateException("Não foi encontrada nenhuma feature");
		}
	}

	public WebDriver retornarDriver() {
		WebDriver driver = DriverConfig.getDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		return driver;
	}

	public void capturarScreenshot() {
		try {
			Allure.addAttachment(System.getProperty("nomeCenario"),
					new ByteArrayInputStream(((TakesScreenshot) retornarDriver()).getScreenshotAs(OutputType.BYTES)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
