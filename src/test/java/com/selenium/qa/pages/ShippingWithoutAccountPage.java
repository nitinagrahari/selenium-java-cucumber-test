package com.selenium.qa.pages;

import com.selenium.qa.factory.DriverFactory;
import com.selenium.qa.util.Helper;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ShippingWithoutAccountPage {

    // FedEx Manager Lite page WebElements aka Shipping without account process
    @FindBy(css = "div[id='fx-appNav'] h1:nth-child(1)")
    private WebElement fedEXShipManagerLite;
    @FindBy(id = "fx-from-name")
    private WebElement fromName;
    @FindBy(id = "fx-from-country")
    private WebElement fromCountrytemp;
    @FindBy(css = "select#fx-from-country")
    private WebElement fromCountry;
    @FindBy(id = "fx-from-addr1")
    private WebElement fromStreet;
    @FindBy(id = "fx-from-zip")
    private WebElement fromPostalCode;
    @FindBy(id = "fx-from-city")
    private WebElement fromCity;
    @FindBy(css = ".fxmod-hinter-drop")
    private WebElement cityDropDownIcon;
    @FindBy(id = "fx-from-phone")
    private WebElement fromPhoneNumber;
    @FindBy(id = "fx-to-name")
    private WebElement toName;
    @FindBy(id = "fx-to-country")
    private WebElement toCountry;
    @FindBy(id = "fx-to-addr1")
    private WebElement toStreet;
    @FindBy(id = "fx-to-zip")
    private WebElement toPostalCode;
    @FindBy(id = "fx-to-city")
    private WebElement toCity;
    @FindBy(id = "fx-to-phone")
    private WebElement toPhoneNumber;
    @FindBy(id = "fx-to-resident-delivery")
    private WebElement toResidentDelivery;
    @FindBy(id = "fx-loading-div")
    private WebElement loader;
    @FindBy(css = "img[aria-label='FedEx Box']")
    private WebElement fedExBox;
    @FindBy(id = "fx-package-recal-packageWeight")
    private WebElement packageWeight;
    @FindBy(id = "fx-package-recalculateRates")
    private WebElement calRatesButton;
    @FindBy(id = "rateBlock0")
    private WebElement rateBlock;
    @FindBy(css = "img[aria-label='FedEx Pak']")
    private WebElement fedExPak;
    @FindBy(css = "img[aria-label='FedEx Tube']")
    private WebElement fedExTube;
    @FindBy(id = "fx-shipment-details-button")
    private WebElement continueButtonOnShipmentSection;
    @FindBy(css = "div[id='paymentSection'] h3[class='fx-title']")
    private WebElement paymentSectionTitle;
    @FindBy(id = "fx-address-button")
    private WebElement continueButtonOnAddressSection;

    private HomePage homePage = new HomePage(DriverFactory.driver);
    private Helper helper = new Helper();

    // constructor with PageFactory to initiate all the page objects
    public ShippingWithoutAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // verifying FedEx Ship Manager Lite is displayed when we try to ship without account
    public boolean isFedExShipManagerLitePageDisplayed() {
        homePage.navigateToFedExShipManagerLitePage();
        return fedEXShipManagerLite.isDisplayed();
    }

    // To fill From Address of shipment
    public void fillFromAddressOfShipment(DataTable dataTable) {
        List<Map<String, String>> dataMapFrom = dataTable.asMaps();

        //filling fromAddress Details
        fromName.sendKeys(dataMapFrom.get(0).get("Name"));
        helper.selectFromDropDownByType(fromCountry, "ByVisibleText", dataMapFrom.get(0).get("Country"));
        fromStreet.sendKeys(dataMapFrom.get(0).get("Address"));
        fromPostalCode.sendKeys(dataMapFrom.get(0).get("Postal code"));
        fromCity.click();
        cityDropDownIcon.isDisplayed();
        helper.waitForElementToBeClickable(fromCity);
        fromCity.sendKeys((dataMapFrom.get(0).get("City")).toUpperCase());
        fromPhoneNumber.sendKeys(dataMapFrom.get(0).get("Phone"));
    }

    // filling To Address of shipment
    public void fillToAddressOfShipment(DataTable dataTable) {
        List<Map<String, String>> dataMapTo = dataTable.asMaps();

        //filling toAddress details
        toName.sendKeys(dataMapTo.get(0).get("Name"));
        helper.selectFromDropDownByType(toCountry, "ByVisibleText", dataMapTo.get(0).get("Country"));
        toStreet.sendKeys(dataMapTo.get(0).get("Address"));
        toPostalCode.sendKeys(dataMapTo.get(0).get("Postal code"));
        toCity.sendKeys((dataMapTo.get(0).get("City")).toUpperCase());
        toPhoneNumber.sendKeys(dataMapTo.get(0).get("Phone"));
        if (Objects.equals(dataMapTo.get(0).get("IsResidentialAddress"), "Yes")) {
            toResidentDelivery.click();
        }
        continueButtonOnAddressSection.click();
    }

    //fill data in Shipment section/accordion
    public void fillShipmentDetails(DataTable dataTable) {
        List<Map<String, String>> dataMapShipment = dataTable.asMaps();
        selectPackageType(dataMapShipment.get(0).get("Package Type"));
        packageWeight.sendKeys(dataMapShipment.get(0).get("Package Weight"));
        calRatesButton.click();
        rateBlock.click();
    }

    public void clickContinueButtonOnShipmentSection() {
        continueButtonOnShipmentSection.click();
    }

    public boolean isPaymentSectionDisplayed() {
        return paymentSectionTitle.isDisplayed();
    }

    public void selectPackageType(String packageType) {
        switch (packageType) {
            case "FedEx Box":
                fedExBox.click();
                break;
            case "FedEx Pak":
                fedExPak.click();
                break;
            case "FedEx Tube":
                fedExTube.click();
                break;
        }
    }
}
