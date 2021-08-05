package app;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.internal.com.google.protobuf.ByteString.Output;

public class AppHooks {
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	private Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driverFactory.init_driver(browserName);
		driverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After(order = 0)
	public void QuitBrowser() {
		driverFactory.getDriver().quit();
	}
	
//	@After(order = 1)
//	public void TearDown(Scenario sc) {
//		if(sc.isFailed()) {
//			String screenshotName = sc.getName().replaceAll(" ","_");
//			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			sc.attach(sourcePath,"image/png",screenshotName);
//		}
//	}
	

}
