package com.selenium.qa.pages;

import com.selenium.qa.factory.DriverFactory;
import com.selenium.qa.util.Helper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TrackShipmentPage {

    // Track Shipment section webelements
    @FindBy(css = "span[aria-label='Get Tracking Information']")
    private WebElement getTrackingInformation;
    @FindBy(id = "trackingnumber")
    private WebElement trackingNumber;
    @FindBy(id = "btnSingleTrack")
    private WebElement trackButton;
    @FindBy(className = "systemErrorMessageTop")
    private WebElement errorNoTackingFound;
    @FindBy(css = ".fdx-u-color--text.fdx-u-line-height--large.fdx-u-mt--2.text-left")
    private WebElement systemError;
    @FindBy(id = "trackingModuleTrackingNum")
    private WebElement trackingNumberTextBoxGridMenu;
    @FindBy(css = "button[aria-label='Click here to track your package']")
    private WebElement trackButtonGridMenu;
    @FindBy(id = "btnMultiTrack")
    private WebElement btnMultiTrack;
    @FindBy(css = "span[class='systemErrorMessageTop']")
    private WebElement invalidMultiTrackErrorMessage;
    @FindBy(id = "trackingnumber[]")
    private List<WebElement> trackingTextBox;

    private HomePage homePage = new HomePage(DriverFactory.driver);
    private Helper helper =new Helper();

    // constructor with PageFactory to initiate all the page objects
    public TrackShipmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



    // verifying track section is displayed
    public boolean isTrackSectionDisplay() {
        return helper.waitForElementToBeVisible(trackButton);
    }

    // track shipment option is displayed from the grid menu of home page
    public boolean isTrackShipmentOptionOnGridMenuIsDisplayed() {
        homePage.clickTrackingDropDownFromGridMenu();
        return trackingNumberTextBoxGridMenu.isDisplayed();
    }

    // to track shipment
    public void trackShipment(int trackingID) {
        trackingNumber.sendKeys(Integer.toString(trackingID));
        trackButton.sendKeys(Keys.TAB);
        if (helper.waitForElementToBeClickable(trackButton)){
            trackButton.click();
        }
    }

    // tracking shipment from top Grid menu of home page
    public void trackShipmentFromGridMenu(int trackingID) {
        trackingNumberTextBoxGridMenu.sendKeys(Integer.toString(trackingID));
        trackButtonGridMenu.click();
    }

    // to track multiple shipment
    public void trackMultipleShipments(List<Integer> trackingIds) {
        homePage.clickMultipleTrackingNumbersOption();
        List<WebElement> trackIds = trackingTextBox;
        trackIds.get(0).click();
        trackIds.get(0).sendKeys(Integer.toString(trackingIds.get(0)));
        trackIds.get(1).click();
        trackIds.get(1).sendKeys(Integer.toString(trackingIds.get(2)));
        trackIds.get(2).click();
        trackIds.get(2).sendKeys(Integer.toString(trackingIds.get(2)));
        btnMultiTrack.click();
    }

    // capturing error message when tracking shipment with invalid tracking id
    public String captureErrorMessageForInvalidTrackingNumber() {
        try {
            errorNoTackingFound.isDisplayed();
            return errorNoTackingFound.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    // capturing error message when tracking shipment with invalid tracking id -- multitple
    public String captureErrorMessageForMultipleInvalidTrackingNumber() {
        try {
            invalidMultiTrackErrorMessage.isDisplayed();
            return invalidMultiTrackErrorMessage.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
