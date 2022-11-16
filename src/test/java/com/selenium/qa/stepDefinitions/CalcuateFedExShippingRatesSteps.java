package com.selenium.qa.stepDefinitions;

import com.selenium.qa.factory.DriverFactory;
import com.selenium.qa.pages.CalculateFedExShippingRatesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CalcuateFedExShippingRatesSteps {

    private CalculateFedExShippingRatesPage calculateFedExShippingRatesPage = new CalculateFedExShippingRatesPage(DriverFactory.driver);

    @Given("I am on Calculate FedEx shipping rates section")
    public void calculateFedExShippingRatesPageIsDisplayed() {
        Assert.assertTrue(calculateFedExShippingRatesPage.isCalculateFedExShippmentRatesPageDisplayed(), "User is on 'Calculate FedEx shipping rates' section");
    }

    @When("^I enter shipment information such as (.*), (.*), (.*), (.*), (.*)$")
    public void enterShipmentInfo(String fromLocation, String toLocation, String packagesType, int noOfPackages, int weightPerPackage) throws InterruptedException {
        calculateFedExShippingRatesPage.fillDetailsToCalculateRates(fromLocation, toLocation, packagesType, noOfPackages, weightPerPackage);
    }

    @And("I click on 'SHOW RATES' button")
    public void clickShowRatesButton() {
        calculateFedExShippingRatesPage.clickShowRatesButton();
    }

    @Then("Calculated rates are displayed along with expected delivery date and time")
    public void verifyShipmentRatesDateTimeIsDisplayed() {
        String rates = calculateFedExShippingRatesPage.verifyshipmentRatesDateTimeCalculated();
        Assert.assertNotNull(rates, "Rates are not displayed");
    }
}
