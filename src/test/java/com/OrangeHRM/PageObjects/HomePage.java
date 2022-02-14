package com.OrangeHRM.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HomePage {
    WebDriver xdriver;

    public HomePage(WebDriver driver) {
        xdriver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getWelcomeMessage(){
        return xdriver.findElement(By.id("welcome")).getText();
    }

    @FindBy(id = "welcome")
    WebElement userName;

    ////a[normalize-space()='Logout']
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutLink;

    @FindBy(id = "MP_link")
    WebElement mpLink;

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement adminLink;

    @FindBy(id = "menu_admin_UserManagement")
    WebElement userManagementLink;

    @FindBy(id = "menu_admin_viewSystemUsers")
    WebElement usersLink;

    @FindBy(id = "btnAdd")
    WebElement addButton;

    @FindBy(id = "searchBtn")
    WebElement searchButton;

    @FindBy(id = "searchSystemUser_userName")
    WebElement userNameSearchField;

    
    public void logout() throws InterruptedException {
        userName.click();
        Thread.sleep(3000);
        logoutLink.click();
    }

    public boolean checkMPLinkPresent(){
        return mpLink.isDisplayed();
    }



    public void navigateToUsers() throws InterruptedException {

        Actions action = new Actions(xdriver);
        action.moveToElement(adminLink).moveToElement(userManagementLink).moveToElement(usersLink).click().build().perform();
        Thread.sleep(3000);
    }

    public void clickAddButton(){
        addButton.click();
    }


    public void enteruserNameinSearch(String uname){
        userNameSearchField.sendKeys(uname);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    ////table[@id='resultTable']/tbody/tr/td[]

    public ArrayList<WebElement> verifySearchData(){
        ArrayList<WebElement> values = new ArrayList<WebElement>();
        for(int x=2;x<=5;x++){
        values.add(xdriver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td["+x+"]")));
        }
        return values;
    }
}
