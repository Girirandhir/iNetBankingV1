package com.inetbanking.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    WebDriver driver;
    public AddCustomerPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    WebElement linkAddNewCustomer;

    @FindBy(how= How.NAME, using ="name")
    @CacheLookup
    WebElement txtCustomerName;

    @FindBy(how= How.NAME, using ="rad1")
    @CacheLookup
    WebElement rdGender;

    @FindBy(how= How.ID_OR_NAME, using ="dob")
    @CacheLookup
    WebElement txtDOB;

    @FindBy(how= How.NAME, using ="addr")
    @CacheLookup
    WebElement txtAddress;

    @FindBy(how= How.NAME, using ="city")
    @CacheLookup
    WebElement txtCity;

    @FindBy(how= How.NAME, using ="state")
    @CacheLookup
    WebElement txtState;

    @FindBy(how= How.NAME, using ="pinno")
    @CacheLookup
    WebElement txtPinNo;

    @FindBy(how= How.NAME, using ="telephoneno")
    @CacheLookup
    WebElement txtTelephoneNo;

    @FindBy(how= How.NAME, using ="emailid")
    @CacheLookup
    WebElement txtEmailId;

    @FindBy(how= How.NAME, using ="password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(how= How.NAME, using ="sub")
    @CacheLookup
    WebElement btnSubmit;

    public void clickAddNewCustomer(){
        linkAddNewCustomer.click();
    }
    public void customerName(String name){
        txtCustomerName.sendKeys(name);
    }
    public void selectCustomerGender(String gender){
        rdGender.click();
    }
    public void setCustomerDOB(String dd,String mm,String yy){
        txtDOB.sendKeys(mm);
        txtDOB.sendKeys(dd);
        txtDOB.sendKeys(yy);
    }
    public void customerAddress(String address){
        txtAddress.sendKeys(address);
    }
    public void customerCity(String address){
        txtCity.sendKeys(address);
    }
    public void customerState(String address){
        txtState.sendKeys(address);
    }
    public void customerPinNo(String address){
        txtPinNo.sendKeys(String.valueOf(address));
    }
    public void customerTelephone(String telephone){
        txtTelephoneNo.sendKeys(telephone);
    }
    public void customerEmailId(String email){
        txtEmailId.sendKeys(email);
    }
    public void customerPassword(String password){
        txtPassword.sendKeys(password);
    }
    public void clickSubmit(){
        btnSubmit.click();
    }






}
