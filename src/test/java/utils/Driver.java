package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;

public class Driver {

	public static WebDriver driver;

	public static WebDriver getDriver() { 
		String browser = System.getProperty("browser");
		if(browser == null) {
			browser = TestDataReader.getProperty("browser");
		}
		if(driver == null) {			
			switch(browser) {
		
				case "chrome":
					//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sheeh\\OneDrive\\Documents\\Tools\\chromedriver_win32\\chromedriver.exe");
					ChromeDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "firefox":
					//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sheeh\\OneDrive\\Documents\\Tools\\geckodriver-v0.32.0-win32\\geckodriver.exe");
					FirefoxDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				default:
					//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sheeh\\OneDrive\\Documents\\Tools\\chromedriver_win32\\chromedriver.exe");
					ChromeDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				break;	
				
			}
				
		}
		return driver;

	}
		public static void quitDriver() {
			if(driver != null) {
				driver.quit();
				driver = null;
			}
		}
	
}

