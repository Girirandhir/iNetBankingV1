package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="uid")
    WebElement txtUserName;

    @FindBy(name="password")
    WebElement txtPassword;

    @FindBy(name="btnLogin")
    WebElement btnLogin;

    @FindBy(linkText = "Log out")
    WebElement lnkLogout;

    public void setTxtUserName(String uname){
        txtUserName.sendKeys(uname);
    }
    public void setTxtPassword(String pwd){
        txtPassword.sendKeys(pwd);
    }
    public void clickSubmit(){
        btnLogin.click();
    }
    public void clickLogout(){lnkLogout.click();}
}
