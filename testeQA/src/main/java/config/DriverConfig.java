package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverConfig {

	public static WebDriver driver;

	public WebDriverWait wait;
	private static boolean loader = false;

	public DriverConfig(WebDriver driver) {
		DriverConfig.driver = driver;

	}

	public DriverConfig() {

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static WebDriver selecionarBrowser(String nomeBrowser) throws WebDriverException {

		switch (nomeBrowser) {
		case "firefox":
			fireFoxSelenium();
			break;
		default:
			System.out.println("browser : " + nomeBrowser + " é inválido, executando o firefox...");

			break;
		}

		return driver;
	}

	public static void fireFoxSelenium() {

		String BINARIO_FIREFOX = "";
		String PROFILE_USUARIO = System.getProperty("user.home");
		String PATH_ABSOLUTO_GECHO_SERVER = null;

		PATH_ABSOLUTO_GECHO_SERVER = PROFILE_USUARIO + "\\drivers\\geckodriver.exe";
		BINARIO_FIREFOX = PROFILE_USUARIO + "\\navegadores\\firefox92\\firefox.exe";
		System.setProperty("webdriver.gecko.driver", PATH_ABSOLUTO_GECHO_SERVER);

		try {

			FirefoxOptions options = new FirefoxOptions();
			FirefoxProfile firefoxProfile = new FirefoxProfile();

			firefoxProfile.setAlwaysLoadNoFocusLib(true);
			firefoxProfile.setAcceptUntrustedCertificates(true);
			firefoxProfile.setPreference("layout.css.devPixelsPerPx", "1.0");

			options.setProfile(firefoxProfile);
			options.setBinary(BINARIO_FIREFOX);

			driver = new FirefoxDriver(options);
			loader = true;

			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

		} catch (Exception e) {
			loader = false;
			System.out.println(e.getMessage());

		}

	}
	
public static void getURL(String url) {
		
		if (isDriverLoader() == true){
		
			driver.get(url);
		} 
			
	}
	
	public  void getURLNewTab(String url) {
		
		if (isDriverLoader() == true){
		
			driver.get(url);
		} 
			
	}
	 
	public static  Boolean isDriverLoader() {
		
		if (loader == true){
			
			return true;
		}else{
			return false;
		}
		
	}
}
