package com.selenium.qa.stepDefinitions;

import com.selenium.qa.factory.DriverFactory;
import com.selenium.qa.pages.TrackShipmentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class TrackShipmentSteps {

    private final TrackShipmentPage trackShipmentPage = new TrackShipmentPage(DriverFactory.driver);


    @Given("I am on Track Shipment section")
    public void trackShipmentSectionIsDisplayed() {
        Assert.assertTrue(trackShipmentPage.isTrackSectionDisplay(), "'Track Shipment' section is not displayed");
    }

    @When("I track invalid tracking id {int}")
    public void trackInvalidTrackingId(int trackingID) {
        trackShipmentPage.trackShipment(trackingID);
    }

    @When("I track invalid tracking id from grid menu {int}")
    public void trackInvalidTrackingIdFromGridMenu(int trackingID) {
        trackShipmentPage.trackShipmentFromGridMenu(trackingID);
    }

    @Then("I can see error message")
    public void verifyErrorMessageIsDisplayed() {
        String actualMessage = trackShipmentPage.captureErrorMessageForInvalidTrackingNumber();
        Assert.assertTrue(actualMessage.contains("No record of this tracking number"), "Expected error message is not displayed");
    }

    @Given("I came to track shipment section from the grid menu-Tracking")
    public void isTrackShipmentOptionOnGridMenuDisplayed() {
        Assert.assertTrue(trackShipmentPage.isTrackShipmentOptionOnGridMenuIsDisplayed(), "Track Shipment Option is not displayed");
    }

    @When("I track multiple invalid tracking ids")
    public void trackInvalidTrackingIds(List<Integer> trackingIDs) {
        trackShipmentPage.trackMultipleShipments(trackingIDs);
    }

    @Then("^I can see error message (.*) for multiple invalid tracking numbers$")
    public void errorMessageForMultipleIdTrackingNumbers(String errMsg) {
        String actualMessage = trackShipmentPage.captureErrorMessageForMultipleInvalidTrackingNumber();
        Assert.assertTrue(actualMessage.contains(errMsg), "Expected error message is not displayed");
    }
}
