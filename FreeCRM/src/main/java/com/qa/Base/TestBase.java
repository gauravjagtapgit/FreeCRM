package com.qa.Base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\gauav\\FreeCRM"
					+ "\\src\\main\\java\\com\\qa\\configaration\\com.qa.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initilaizetion() {
		String browername = prop.getProperty("browser");
		if (browername.equals("chrome")) {
			System.getProperty("webdriver.chrome.driver",
					"C:\\Users\\ADMIN\\eclipse-workspace\\gauav\\driver\\Chromedriver.exe");

				System.setProperty("webdriver.chrome.driver", "C:\\Users\\\\ADMIN\\eclipse-workspace\\gauav\\driver\\chromedriver.exe");
				ChromeOptions options=new  ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--disable notifications");
				DesiredCapabilities cp=new DesiredCapabilities();
				cp.setCapability(ChromeOptions.CAPABILITY,options);
				options.merge(cp);

			driver = new ChromeDriver(options);

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}












