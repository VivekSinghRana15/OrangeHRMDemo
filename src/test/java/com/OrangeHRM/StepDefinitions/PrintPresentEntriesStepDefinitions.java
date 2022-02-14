package com.OrangeHRM.StepDefinitions;

import com.OrangeHRM.PageObjects.HomePage;
import io.cucumber.java.en.*;
import org.apache.log4j.PropertyConfigurator;

public class PrintPresentEntriesStepDefinitions extends BaseClass{

    @Given("We log in to Orange HRM using Admin credentials")
    public void login_using_admin_credentials() throws InterruptedException {
        setChromeDriver();
        loginOrangeHRM(driver);
        PropertyConfigurator.configure("log4j.properties");
    }

    @And ("We navigate to Users")
    public void navigate_To_Users() throws InterruptedException {
        homePageObj = new HomePage(driver);
        homePageObj.navigateToUsers();
        logger.info("Navigated to Users Page..");
    }

    @When ("We print the present values in the System User Table")
    public void print_all_values_in_table(){
        homePageObj.printUserTableData();
    }

    @Then ("We logout & close the browser")
    public void logout_and_close_browser() throws InterruptedException {
        homePageObj.logout();
        logger.info("Logged out successfully...");
        closeBrowser(driver);
    }


}
