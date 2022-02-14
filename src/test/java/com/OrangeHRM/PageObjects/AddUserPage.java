package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {
    WebDriver xdriver;

    public AddUserPage(WebDriver driver){
        xdriver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "systemUser_userType")
    WebElement userRoleDropdown;

    @FindBy(id = "systemUser_employeeName_empName")
    WebElement employeeName;

    @FindBy(id = "systemUser_userName")
    WebElement userName;

    @FindBy(id = "systemUser_status")
    WebElement statusDropdown;

    @FindBy(id = "systemUser_password")
    WebElement password;

    @FindBy(id = "systemUser_confirmPassword")
    WebElement confPassword;

    @FindBy(id = "btnSave")
    WebElement saveButton;

    public void selectUserRole(String userRole){
        Select userRoleList = new Select(userRoleDropdown);
        userRoleList.selectByVisibleText(userRole);
    }

    public void setEmployeeName(String empName){
        employeeName.sendKeys(empName);
    }

    public void setUserName(String uName){
        userName.sendKeys(uName);
    }

    public void selectStatus(String status){
        Select statusList = new Select(statusDropdown);
        statusList.selectByVisibleText(status);
    }

    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }

    public void setConfirmPassword(String confpwd){
        confPassword.sendKeys(confpwd);
    }

    public void clickSaveButton(){
        saveButton.click();
    }

}
