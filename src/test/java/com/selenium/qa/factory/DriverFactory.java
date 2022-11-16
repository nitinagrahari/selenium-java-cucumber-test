package com.selenium.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver driver;

    public WebDriver initDriver(String browser) {

        browser = browser.toUpperCase();

        // use WebDriverManager to automatically setup driver of the browser
        WebDriverManager.getInstance(DriverManagerType.valueOf(browser)).setup();
        // launch appropriate browser
        switch (browser) {
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "SAFARI":
                driver = new SafariDriver();
                break;
            case "EDGE":
                driver = new EdgeDriver();
                break;
            case "OPERA":
                driver = new OperaDriver();
                break;
            case "IEXPLORER":
                driver = new InternetExplorerDriver();
                break;
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}