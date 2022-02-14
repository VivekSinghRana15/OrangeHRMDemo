package com.OrangeHRM.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

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

    public void printUserTableData(){

        System.out.println("********************************************************************************");
        //table[@id='resultTable']/thead/tr/th[2]
        for(int a =2;a<=5;a++){
            String b = xdriver.findElement(By.xpath("//table[@id='resultTable']/thead/tr/th["+a+"]")).getText();
            System.out.format("%20s",b);
        }
        System.out.println();

        List<WebElement> tableRows = xdriver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
        int rowCount = tableRows.size();
        System.out.println("********************************************************************************");
        for(int i=1;i<rowCount;i++){
            for(int j =2;j<=5;j++){
                String x = xdriver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.format("%20s",x);
            }
            System.out.println();
        }
        System.out.println("*********************************************************************************");
    }
}
