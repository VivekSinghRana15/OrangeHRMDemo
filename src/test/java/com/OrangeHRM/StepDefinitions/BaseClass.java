package com.OrangeHRM.StepDefinitions;

import com.OrangeHRM.PageObjects.AddUserPage;
import com.OrangeHRM.PageObjects.HomePage;
import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.Utilities.ReadConfig;
import org.apache.log4j.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;


public class BaseClass {
    LoginPage loginPageObj;
    WebDriver driver;
    HomePage homePageObj;
    AddUserPage addUserPageObj;
    ReadConfig readConf = new ReadConfig();
    String url = readConf.getURL();
    String userName = readConf.getUserName();
    String passWord = readConf.getPassword();
    Logger logger = Logger.getLogger("OrangeHRM");

    public void closeBrowser(WebDriver driver){
        driver.quit();
    }

    public int randomNumber(){
        Random rand =  new Random();
        return rand.nextInt(1000);
    }

    public void loginOrangeHRM(WebDriver driver){
        driver.get(url);
        loginPageObj = new LoginPage(driver);
        Assert.assertEquals("OrangeHRM",loginPageObj.getPageTitle());
        logger.info("The Orange HRM login page is open now...");

        loginPageObj.enterUserName(userName);
        logger.info("Username is entered: "+userName);
        loginPageObj.enterPassword(passWord);
        logger.info("Password is entered: "+passWord);
        loginPageObj.clickLoginButton();
        logger.info("Clicked Login Button..");

        homePageObj =  new HomePage(driver);
        Assert.assertTrue(homePageObj.checkMPLinkPresent());
        logger.info("We have successfully logged in...");
    }

    public void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver","src/Drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang= locale-of-choice");
        driver = new ChromeDriver(chromeOptions);
    }

    public void setEdgeDriver(){
        System.setProperty("webdriver.edge.driver","src/Drivers/msedgedriver.exe");
        driver =  new EdgeDriver();
    }

    public void setFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver","src/Drivers/geckodriver.exe");
        driver =  new FirefoxDriver();
    }
}
