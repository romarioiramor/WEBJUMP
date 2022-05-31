package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty",
"io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm" }, 
 features = "classpath:features/CenarioUm.feature", 
 monochrome = true, 
 glue = { "bbts.com.br.automacao.steps" })
public class CenarioUmRunner {

	@BeforeClass()
	public static void init() throws Exception {
		bean.AllureReportConfiguration.prepareAllureResultsFolder();
	}

	@AfterClass()
	public static void runReport() throws Exception {
		bean.ExecutaAllureReport.executarRelatorio();

	}
}
