package com.selenium.qa.pages;

import com.selenium.qa.factory.DriverFactory;
import com.selenium.qa.util.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CalculateFedExShippingRatesPage {

    // Calculate Shipment section WebElements
    @FindBy(css = "span[aria-label='Get Rate and Shipping Details']")
    private WebElement rateAndTransitTimesTab;
    @FindBy(id = "magr-heading")
    private WebElement headerCalculateRate;
    @FindBy(id = "fromGoogleAddress")
    private WebElement fromGoogleAddress;
    @FindBy(xpath = "//span[@class='fdx-u-font-size--default']")
    private WebElement autosuggestedAddress;
    @FindBy(id = "toGoogleAddress")
    private WebElement toGoogleAddress;
    @FindBy(id = "package-details__package-type")
    private WebElement packageType;
    @FindBy(id = "package-details__quantity-0")
    private WebElement packageQuantity;
    @FindBy(id = "package-details__weight-0")
    private WebElement packageWeight;
    @FindBy(id = "e2ePackageDetailsSubmitButtonRates")
    private WebElement showRatesButton;
    @FindBy(xpath = "//div[@class='fdx-u-align--right fdx-u-font-size--h6 magr-c-rates__price fdx-u-text--light']")
    private WebElement rates;

    private WebDriver driver;
    private HomePage homePage = new HomePage(DriverFactory.driver);
    // to invoke some reusable method from Helper class
    private Helper helper = new Helper();

    // constructor with PageFactory to initiate all the page objects
    public CalculateFedExShippingRatesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Verifying calculate shipment page is displayed
    public boolean isCalculateFedExShippmentRatesPageDisplayed() {
        homePage.clickOnHomePageTabs("RateAndTransitTimes");
        return headerCalculateRate.isDisplayed();
    }

    // to fill details while calculating rates
    public void fillDetailsToCalculateRates(String fromAddress, String toAddress, String packagingType, int noOfPackages, int weightPerPackage) {
        fromGoogleAddress.sendKeys(fromAddress);
        autosuggestedAddress.click();
        toGoogleAddress.sendKeys(toAddress);
        helper.waitForElementToBeVisible(autosuggestedAddress);
        autosuggestedAddress.click();
        helper.selectFromDropDownByType(packageType, "ByVisibleText", packagingType);
        helper.selectFromDropDownByType(packageQuantity, "ByVisibleText", Integer.toString(noOfPackages));
        packageQuantity.click();
        packageWeight.sendKeys(Integer.toString(weightPerPackage));

    }

    // to click on show rates button
    public void clickShowRatesButton() {
        showRatesButton.click();
    }

    // to get calculated rates of the shipment
    public String verifyshipmentRatesDateTimeCalculated() {
        return rates.getText();
    }

}