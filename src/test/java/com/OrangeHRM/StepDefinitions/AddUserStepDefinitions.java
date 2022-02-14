package com.OrangeHRM.StepDefinitions;

import com.OrangeHRM.PageObjects.AddUserPage;
import com.OrangeHRM.PageObjects.HomePage;
import com.OrangeHRM.PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class AddUserStepDefinitions extends BaseClass{
    //WebDriver driver;
    String createdUserName;
    String userRole;
    String empName;
    String status;


    @Given("We login to Orange HRM using Admin credentials")
    public void login_using_admin_credentials() throws InterruptedException {

        setChromeDriver();
        loginOrangeHRM(driver);
        PropertyConfigurator.configure("log4j.properties");
    }

    @Given("We hover over Admin tab and select UserManagement and then click Users")
    public void navigate_to_Users() throws InterruptedException {
        homePageObj = new HomePage(driver);
        homePageObj.navigateToUsers();
        logger.info("Navigated to Users Page..");
    }


    @When("we click on Add button")
    public void click_add_button() {
        homePageObj.clickAddButton();
    }

    @When("On Add User Page we enter {string},{string},{string},{string} and {string}")
    public void enter_values(String userRole, String empName, String userName, String status, String pwd) throws InterruptedException {

        this.userRole = userRole;
        this.empName = empName;
        this.status = status;
        createdUserName= userName+randomNumber();

        addUserPageObj = new AddUserPage(driver);

        addUserPageObj.selectUserRole(userRole);
        logger.info("User Role selected as "+userRole);
        Thread.sleep(1000);

        addUserPageObj.setEmployeeName(empName);
        logger.info("Employee Name set as "+empName);
        Thread.sleep(1000);


        addUserPageObj.setUserName(createdUserName);
        logger.info("User Name set as "+createdUserName);
        Thread.sleep(1000);


        addUserPageObj.selectStatus(status);
        logger.info("Status is set as "+status);
        Thread.sleep(1000);

        addUserPageObj.setPassword(pwd);
        logger.info("Password is set ..");
        Thread.sleep(1000);

        addUserPageObj.setConfirmPassword(pwd);
        logger.info("Confirm Password is set ..");
        Thread.sleep(3000);


    }

    @When("Click on Save")
    public void click_on_save() throws InterruptedException {
        addUserPageObj.clickSaveButton();
        logger.info("Clicked Save button");
        Thread.sleep(1000);
    }

    @Then("We should be able to Search for the Created User")
    public void search_For_CreatedUser() throws InterruptedException {

        homePageObj.enteruserNameinSearch(createdUserName);
        logger.info("username entered into search field");
        homePageObj.clickSearchButton();
        logger.info("Clicked Search Button");
        Thread.sleep(3000);
    }

    @And ("Data Appearing should match the entered values")
    public void verify_data_matches_entered_values(){
       ArrayList<WebElement> valuesOnPage =  homePageObj.verifySearchData();

       Assert.assertEquals(createdUserName,valuesOnPage.get(0).getText());
        logger.info("UserName is as expected");
        Assert.assertEquals(userRole,valuesOnPage.get(1).getText());
        logger.info("User Role is as expected");
        Assert.assertEquals(empName,valuesOnPage.get(2).getText());
        logger.info("Employee Name is as expected");
        Assert.assertEquals(status,valuesOnPage.get(3).getText());
        logger.info("Status is as expected");
    }

    @And("logout and close the browser")
    public void logout_and_Close_Browser() throws InterruptedException {
        homePageObj.logout();
        logger.info("Logged out successfully...");
        closeBrowser(driver);
    }


}
