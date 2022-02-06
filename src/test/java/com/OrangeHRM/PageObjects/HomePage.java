package com.OrangeHRM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutLink;

    public void logout() throws InterruptedException {
        userName.click();
        Thread.sleep(3000);
        logoutLink.click();

    }

}
