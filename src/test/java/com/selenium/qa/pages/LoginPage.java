package com.selenium.qa.pages;

import com.selenium.qa.factory.DriverFactory;
import com.selenium.qa.util.Helper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public Helper helper = new Helper();
    HomePage homePage = new HomePage(DriverFactory.driver);
    // Login page WebElements
    @FindBy(id = "userId")
    private WebElement userId;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-btn")
    private WebElement loginButton;
    @FindBy(id = "invalidCredentials")
    private WebElement invalidCredentialsMsg;
    @FindBy(id = "requestCode-btn")
    private WebElement forgetPasswordButton;
    @FindBy(id = "reset-btn")
    private WebElement resetPasswordButton;
    @FindBy(id = "submit-btn")
    private WebElement submitButton;
    @FindBy(id = "pwdResetMethod-title")
    private WebElement pwdResetMethodsTitle;
    @FindBy(css = "div[class='fdx-o-grid']")
    private WebElement pwdResetMethodGrid;
    @FindBy(id = "sendanEmail-btn")
    private WebElement sendEmailButton;
    @FindBy(id = "sendaText-btn")
    private WebElement sendTextButton;
    @FindBy(id = "callMe-btn")
    private WebElement callMeButton;
    @FindBy(id = "title")
    private WebElement refreshPageWarning;

    // constructor with PageFactory to initiate all the page objects
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    // actions or functions on the Login Page

    //verifying Login Page is displayed using User Id field of Login Page
    public boolean isLoginPageDisplayed() {
        return helper.waitForElementToBeVisible(userId);
    }

    // logging in to application
    public void login(String userID, String pwd) {
        // homePage.navigateToLoginPage();
        userId.sendKeys(userID);
        password.sendKeys(pwd);
        loginButton.click();
    }

    //navigate to ResetPasswordMethodPage
    public void resetPassword(String userID) {
        forgetPasswordButton.click();
        resetPasswordButton.click();
        userId.sendKeys(userID);
        submitButton.click();
    }

    public boolean isResetPasswordMethodPageDisplayed() {
        return helper.waitForElementToBeVisible(pwdResetMethodsTitle);
    }

    //To verify different methods to reset password is available
    public boolean isSendEmailButtonDisplayed() {
        return sendEmailButton.isDisplayed();
    }

    public boolean isSendTextButtonDisplayed() {
        return sendEmailButton.isDisplayed();
    }

    public boolean isCallMeButtonDisplayed() {
        return sendEmailButton.isDisplayed();
    }

    // To capture error message when user provided multiple invalid tracking numbers
    public boolean isErrorMessageDisplayed() {
        try {
            return invalidCredentialsMsg.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // To capture error message when user provided invalid tracking number
    public String getErrorMessage() {
        try {
            return invalidCredentialsMsg.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}