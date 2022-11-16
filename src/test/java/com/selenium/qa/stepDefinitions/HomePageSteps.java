package com.selenium.qa.stepDefinitions;

import com.selenium.qa.factory.DriverFactory;
import com.selenium.qa.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class HomePageSteps {

    private HomePage homePage = new HomePage(DriverFactory.driver);


    @Given("I am on homepage")
    public void homePageIsDisplayed() {
        Assert.assertTrue(homePage.isHomePageDisplayed(), " Home page is not diplayed");
    }

    @When("I click on Ship tab")
    public void clickShipTab() {
        homePage.navigateToLoginPageFromShipTab();
    }

    @When("I open Shipping drop-down")
    public void clickShippingFromGridMenu() {
        homePage.clickShippingDropDownFromGridMenu();
    }

    @Then("I should see different Shipping options")
    public void shippingOptionsDisplayed(List<String> myList) {
        Assert.assertEquals(homePage.fetchShippingOptionsFromTheDropDownList(), myList);
    }

    @When("I change language to Nederlands")
    public void changeLanguageToNederlands() {
        homePage.selectLanguageNL();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Not redirected to homepage after language selection");
    }

    @Then("Homepage language should successfully change to Nederland")
    public void languageIsChanged() {
        Assert.assertEquals(homePage.getLanguageSelectedValue(), "Nederlands", "Homepage is not changed to Dutch");
    }
}
