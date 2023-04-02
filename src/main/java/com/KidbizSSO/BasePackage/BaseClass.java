package com.KidbizSSO.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.KidbizSSO.Util.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver wd;
	public static WebDriverWait wait;
	public static Properties properties;
	public static FileInputStream file;
	public String openbrowser;
	public String url;
	public static JavascriptExecutor javascriptExecutor;

	public BaseClass() {
		try {
			properties = new Properties();
			file = new FileInputStream(
					"C://Users//singh//Inderjit-workspace//RegressionSSOkb//src//main//java//com//KidbizSSO//Configuration//config.properties");
			properties.load(file);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File not found");
			System.out.println(e);
		}
	}

	public void browserInitialization() {

		// Open set Browser in Config.properties
		openbrowser = properties.getProperty("browser");

		switch (openbrowser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();
			break;

		case ("edge"):
			WebDriverManager.edgedriver().setup();
			wd = new EdgeDriver();
			break;

		default:
			System.out.println("wrong browser");
			break;
		}

		// Explicit wait
		wait = new WebDriverWait(wd, Utils.waitForSeconds);

		// Implicit wait
		

		javascriptExecutor = (JavascriptExecutor) wd;

		wd.manage().window().maximize();

	}
	public void waitForPageToLoad() {
		wd.manage().timeouts().pageLoadTimeout(Utils.waitForSeconds, TimeUnit.SECONDS);
	}
	
	public void quitDriver() {
		wd.quit();
	}

}
