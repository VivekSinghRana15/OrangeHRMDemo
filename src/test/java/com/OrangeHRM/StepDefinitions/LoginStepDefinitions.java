package com.OrangeHRM.StepDefinitions;

import com.OrangeHRM.PageObjects.HomePage;
import com.OrangeHRM.PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinitions extends BaseClass {

    @Given("We Open the Orange HRM website login page")
    public void open_OrangeHRM_login_page() {
        setChromeDriver();
        driver.get(readConf.getURL());

        loginPageObj = new LoginPage(driver);
        PropertyConfigurator.configure("Log4j.properties");
        Assert.assertEquals("OrangeHRM",loginPageObj.getPageTitle());

        logger.info("Successfully opened the Orange HRM login Page...");

    }

    @Given("We enter the {string} and {string}")
    public void enter_UserName_Password(String UserName, String Password) throws InterruptedException {
        loginPageObj.enterUserName(UserName);
        loginPageObj.enterPassword(Password);
        Thread.sleep(3000);

    }

    @When("We click on Login")
    public void click_login() {
        loginPageObj.clickLoginButton();
    }
    @Then("We should successfully login to the application")
    public void verify_Login_to_application() {
        homePageObj= new HomePage(driver);
        Assert.assertEquals("Welcome Paul$#", homePageObj.getWelcomeMessage());
        logger.info("Successfully Logged in to the Application...");

    }

    @Then("Logout and close Browser")
    public void logout_and_close_browser()  throws InterruptedException {
        homePageObj.logout();
        logger.info("Logged out successfully...");
        closeBrowser(driver);
    }


}
