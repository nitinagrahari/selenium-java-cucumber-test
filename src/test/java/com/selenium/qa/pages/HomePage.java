package com.selenium.qa.pages;

import com.selenium.qa.factory.DriverFactory;
import com.selenium.qa.util.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    // HomePage WebElements
    @FindBy(css = ".fxg-user-options__sign-in-text")
    private WebElement signInButton;
    @FindBy(css = "a[title='LOG IN']")
    private WebElement loginButton;
    @FindBy(css = "span[aria-label='Get Rate and Shipping Details']")
    private WebElement rateAndTransitTimesTab;
    @FindBy(css = "span[aria-label='Get Tracking Information']")
    private WebElement getTrackingInformationTab;
    @FindBy(css = "span[aria-label='Get Location Information']")
    private WebElement getLocationInformation;
    @FindBy(xpath = "//span[normalize-space()='Shipping']")
    private WebElement shippingGridMenu;
    @FindBy(xpath = "//span[normalize-space()='Tracking']")
    private WebElement trackingGridMenu;
    @FindBy(css = "a[title='Multiple Tracking Numbers']")
    private WebElement multipleTrackingLink;
    @FindBy(css = "a[title='ship']")
    private WebElement shipWithAccountOption;
    @FindBy(css = "a[title='Ship without account']")
    private WebElement shipWithoutAccountOption;
    @FindBy(css = "a[title='Get Rates & Transit Times']")
    private WebElement getRateAndTransitTimesOption;
    @FindBy(css = "a[title='Schedule & Manage Pickups']")
    private WebElement scheduleAndManagePickupsOption;
    @FindBy(css = "a[title='E-commerce']")
    private WebElement eCommerceOption;
    @FindBy(css = "a[title='Returns']")
    private WebElement returnsOption;
    @FindBy(css = "a[title='Packaging & Shipping Supplies']")
    private WebElement packagingAndShippingSuppliesOption;
    @FindBy(xpath = "//a[contains(@href,'https://www.fedex.com/en-nl/shipping-tools.html')]")
    private WebElement shippingToolsOption;
    @FindBy(css = "a[title='ALL SHIPPING SERVICES']")
    private WebElement allShippingServicesOption;
    @FindBy(css = ".fxg-link[href='http://www.fedex.com/?location=home']")
    private WebElement selectLocation;
    @FindBy(css = "a[aria-label='Europe ']")
    private WebElement selectEuropeRegion;
    @FindBy(xpath = "//a[@href='https://www.fedex.com/nl-nl/home.html']")
    private WebElement selectNederlandsLanguage;
    @FindBy(xpath = "//p[contains(text(),'Netherlands |')]")
    private WebElement selectLanguageForNL;
    @FindBy(id = "dropdownMenu")
    private WebElement languageDropDownMenu;


    private WebDriver driver;
    // to invoke some reusable method from Helper class
    private Helper helper = new Helper();

    // constructor with PageFactory to initiate all the page objects
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // actions or functions on the Home Page

    // verifying Home Page is displayed or not
    public boolean isHomePageDisplayed() {
        return helper.waitForElementToBeVisible(getTrackingInformationTab);
    }

    // navigating to login page from home page
    public void navigateToLoginPage() {
        signInButton.click();
        loginButton.click();
    }

    // navigating to login page from ship tab in home page
    public void navigateToLoginPageFromShipTab() {
        clickOnHomePageTabs("Ship");
    }

    //Here we can create resuable method to select any language as part of project enhancements in future
    public void selectLanguageNL() {
        selectLocation.click();
        selectLanguageForNL.isDisplayed();
        selectNederlandsLanguage.click();
    }

    public String getLanguageSelectedValue() {
        if (helper.waitForElementToBeVisible(languageDropDownMenu)) {
            return languageDropDownMenu.getText();
        } else {
            return "";
        }

    }

    // To navigate to FedEx Ship Manager Lite Page for Shipping without Account Page
    public void navigateToFedExShipManagerLitePage() {
        shippingGridMenu.click();
        shipWithoutAccountOption.click();
    }

    // clicking on different links
    public void clickShippingDropDownFromGridMenu() {
        shippingGridMenu.click();
    }

    public void clickTrackingDropDownFromGridMenu() {
        trackingGridMenu.click();
    }

    public void clickMultipleTrackingNumbersOption() {
        multipleTrackingLink.click();
    }

    // fetching all the options (WebElements) from the Shipping drop-down at grid menu
    public List<String> fetchShippingOptionsFromTheDropDownList() {
        List<String> actualShippingOptions = new ArrayList<String>();
        actualShippingOptions.add(0, shipWithAccountOption.getText());
        actualShippingOptions.add(1, shipWithoutAccountOption.getText());
        actualShippingOptions.add(2, getRateAndTransitTimesOption.getText());
        actualShippingOptions.add(3, scheduleAndManagePickupsOption.getText());
        actualShippingOptions.add(4, eCommerceOption.getText());
        actualShippingOptions.add(5, returnsOption.getText());
        actualShippingOptions.add(6, packagingAndShippingSuppliesOption.getText());
        actualShippingOptions.add(7, shippingToolsOption.getText());
        actualShippingOptions.add(8, allShippingServicesOption.getText());

        return actualShippingOptions;
    }

    // To click on Home Page Tabs "RATES & TRANSIT TIMES, TRACK & SHIP
    public void clickOnHomePageTabs(String tab) {

        switch (tab) {
            case "RateAndTransitTimes":
                rateAndTransitTimesTab.click();
                break;
            case "Track":
                getTrackingInformationTab.click();
                break;
            case "Ship":
                getLocationInformation.click();
                break;
        }
    }
}
