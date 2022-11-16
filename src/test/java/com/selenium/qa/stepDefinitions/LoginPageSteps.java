package com.selenium.qa.stepDefinitions;

import com.selenium.qa.factory.DriverFactory;
import com.selenium.qa.pages.HomePage;
import com.selenium.qa.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginPageSteps {


    LoginPage loginPage = new LoginPage(DriverFactory.driver);
    HomePage homePage = new HomePage(DriverFactory.driver);

    @Then("Application Login Page is displayed")
    public void applicationLoginPageIsDisplayed() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
    }

    @When("^I login with the invalid user id (.*) and invalid password (.*)$")
    public void loginWithInvalidUser(String userId, String password) {
        loginPage.login(userId, password);
    }

    @Then("^I see a error message (.*)$")
    public void erroMessageIsDisplayed(String errMsg) {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed");
        Assert.assertEquals(loginPage.getErrorMessage(), errMsg, "error message is not matching");
    }

    @When("^I want to reset my password with user id (.*)$")
    public void resetPasswordProcess(String userId) {
        loginPage.resetPassword(userId);
    }

    @Then("I see different methods for resetting the password")
    public void isResetPasswordWaysDisplayed() {
        Assert.assertTrue(loginPage.isResetPasswordMethodPageDisplayed(), "Reset Password with different ways page is not displayed");
        Assert.assertTrue(loginPage.isSendEmailButtonDisplayed(), " Send Email method is not availble");
        Assert.assertTrue(loginPage.isSendTextButtonDisplayed(), "Send Text method is not available");
        Assert.assertTrue(loginPage.isCallMeButtonDisplayed(), "Call me method is not available");

    }
}
