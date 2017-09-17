package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

public class baseMethods {
	public static WebDriver driver = initialisetDriver(parameters.getBrowser());
	public WebDriverWait webDriverWait;

	public WebDriver getWebDriver() {
		return driver;
	}

	public WebDriverWait getWaitObj() {
		if (webDriverWait == null) {
			webDriverWait = new WebDriverWait(driver, 60);
		}
		return webDriverWait;
	}

	// function to capture screenshot
	public void captureScreenshot() throws IOException {
		parameters.incrementSequenceCounter();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("reports/screenShots/ageRanger" + parameters.getSequenceCounter() + ".png");
		FileUtils.copyFile(src, destFile);
		Reporter.addScreenCaptureFromPath(destFile.getAbsolutePath());
	}

	public void failedTest() throws IOException {
		File failedFile = new File("reports/failedTest.txt");
		failedFile.createNewFile();
	}

	// function to set driver object
	private static WebDriver initialisetDriver(String browser) {
		parameters p2 = new parameters();
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", p2.getGeckoPath());
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("dom.file.createInChild", true);
			DesiredCapabilities capabilitiesFF = DesiredCapabilities.firefox();
			capabilitiesFF.setCapability("marionette", true);
			capabilitiesFF.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
			capabilitiesFF.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new FirefoxDriver(capabilitiesFF);
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", p2.getChromePath());
			driver = new ChromeDriver();
		} else {
			throw new RuntimeException("Unsupported webdriver: " + browser);
		}
		return driver;
	}
}
