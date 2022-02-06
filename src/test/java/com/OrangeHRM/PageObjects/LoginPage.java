package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver xdriver;


    public LoginPage(WebDriver driver){
        xdriver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "txtUsername")
    WebElement usernameField;

    @FindBy(id = "txtPassword")
    WebElement passwordField;

    @FindBy(id = "btnLogin")
    WebElement loginButton;

    public void enterUserName(String uname){
        usernameField.sendKeys(uname);
    }

    public void enterPassword(String pwd){
        passwordField.sendKeys(pwd);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getPageTitle(){
        return xdriver.getTitle();
    }


}
