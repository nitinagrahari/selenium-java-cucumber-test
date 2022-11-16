package com.selenium.qa.util;

import com.selenium.qa.factory.DriverFactory;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    //Include reusable methods which can be used across the project

    // Can be used if we want to wait laoder in any page is disappeared and the perform action
    public static void loadingWait(WebElement loader) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.driver, 5);
        wait.until(ExpectedConditions.visibilityOf(loader)); // wait for loader to appear
        wait.until(ExpectedConditions.invisibilityOf(loader)); // wait for loader to disappear
    }

    // To select options from Dropdown
    public void selectFromDropDownByType(WebElement webElement, @NotNull String selectBy, String dropDownValueToSelect) {

        Select objSelect = new Select(webElement);
        switch (selectBy) {
            case "ByValue":
                objSelect.selectByValue(dropDownValueToSelect);
                break;

            case "ByVisibleText":
                objSelect.selectByVisibleText(dropDownValueToSelect);
                break;
        }
    }

    // For using explicit wait to check element is getting visible in specific time
    public boolean waitForElementToBeVisible(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.driver, 10);
            try {
                wait.until(ExpectedConditions.visibilityOf(webElement));
                return true;
            } catch (WebDriverException e) {
                e.printStackTrace();
                return false;
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }
    }

    // For using explicit wait to check element is getting clickable in specific time
    public boolean waitForElementToBeClickable(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.driver, 10);
            try {
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
                return true;
            } catch (WebDriverException e) {
                e.printStackTrace();
                return false;
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Fetching locators from WebElement which can be used in Expected Conditions while using explicit wait -> If required
    public By getLocatorFromWebElement(WebElement element) {
        By by;

        String[] locatorVariable = (element.toString().split("->")[1].replaceFirst("(?s)(.*)]", "$1" + "")).split(":");

        String selector = locatorVariable[0].trim();
        String value = locatorVariable[1].trim();

        switch (selector) {
            case "id":
                by = By.id(value);
                break;
            case "className":
                by = By.className(value);
                break;
            case "tagName":
                by = By.tagName(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "css selector":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                throw new IllegalStateException("locator : " + selector + " not found!!!");
        }
        return by;
    }
}
