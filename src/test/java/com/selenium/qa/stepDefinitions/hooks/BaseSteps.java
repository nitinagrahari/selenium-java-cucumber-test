package com.selenium.qa.stepDefinitions.hooks;

import com.selenium.qa.factory.DriverFactory;
import com.selenium.qa.util.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseSteps {

    // declaring all variables
    private WebDriver driver;
    private Properties prop;
    private DriverFactory driverFactory;

    @Before
    public void setup() {
        // this method will run before each scenario
        prop = PropertyReader.getAllProperties();
        driverFactory =  new DriverFactory();

        driver = driverFactory.initDriver(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
        acceptCookiesPolicy(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        // this method will run after each scenario
        if (scenario.isFailed()) {
            // will take screenshot
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
        }
        PropertyReader.cleanUp();
        driver.quit();
    }

    // to accept the cookies in UI
    private void acceptCookiesPolicy(WebDriver webDriver) {
        webDriver.findElement(By.xpath("//button[text()='ACCEPT ALL COOKIES']")).click();
        webDriver.switchTo().defaultContent();
    }
}
