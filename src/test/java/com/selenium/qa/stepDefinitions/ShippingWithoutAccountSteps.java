package com.selenium.qa.stepDefinitions;

import com.selenium.qa.factory.DriverFactory;
import com.selenium.qa.pages.ShippingWithoutAccountPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ShippingWithoutAccountSteps {

    //HomePage homePage  = new HomePage(DriverFactory.getDriver());
    ShippingWithoutAccountPage shippingWithoutAccountPage = new ShippingWithoutAccountPage(DriverFactory.driver);

    @Given("I am on FedEx Ship Manager Lite page")
    public void fedExShipManagerLitePageIsDisplayed() {
        Assert.assertTrue(shippingWithoutAccountPage.isFedExShipManagerLitePageDisplayed(), "FedEx Ship Manager Lite Page is not displayed");
    }

    @When("I provide from address details")
    public void fromAddressDetails(DataTable dataTable) {
        shippingWithoutAccountPage.fillFromAddressOfShipment(dataTable);
    }

    @When("I provide to address details")
    public void toAddressDetails(DataTable dataTable) {
        shippingWithoutAccountPage.fillToAddressOfShipment(dataTable);
    }

    @When("I provide Shipment details")
    public void shipmentDetails(DataTable dataTable) {
        shippingWithoutAccountPage.fillShipmentDetails(dataTable);
    }

    @When("I click on Continue button on shipment details section")
    public void clickContinueOnShipmentDetailsSection() {
        shippingWithoutAccountPage.clickContinueButtonOnShipmentSection();
    }

    @Then("Payment Section is displayed")
    public void paymentSectionIsDisplayed() {
        Assert.assertTrue(shippingWithoutAccountPage.isPaymentSectionDisplayed(), "Payment section is not displayed");
    }
}
