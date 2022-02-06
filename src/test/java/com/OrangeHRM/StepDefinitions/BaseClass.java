package com.OrangeHRM.StepDefinitions;

import com.OrangeHRM.PageObjects.HomePage;
import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.Utilities.ReadConfig;
import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {
    LoginPage loginPageObj;
    WebDriver driver;
    HomePage homePageObj;
    ReadConfig readConf = new ReadConfig();
    Logger logger = Logger.getLogger("OrangeHRM");

    public void closeBrowser(WebDriver driver){
        driver.quit();
    }



    public void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver","src/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
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
