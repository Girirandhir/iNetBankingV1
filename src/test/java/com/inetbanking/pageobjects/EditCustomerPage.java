package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
    WebDriver driver;
    public EditCustomerPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.XPATH, using ="/html/body/div[3]/div/ul/li[3]/a")
    @CacheLookup
    WebElement linkEditCustomer;

    @FindBy(how= How.NAME, using ="cusid")
    @CacheLookup
    WebElement customerIdTxtbox;

    @FindBy(how= How.NAME, using ="AccSubmit")
    @CacheLookup
    WebElement customerRetriveSubmitBtn;

    @FindBy(how= How.NAME, using ="addr")
    @CacheLookup
    WebElement txtCustomerAddress;

    @FindBy(how= How.NAME, using ="sub")
    @CacheLookup
    WebElement btnSubmit;

    public void clickEditCustomer(){
        linkEditCustomer.click();
    }
    public void enterValidCustomerId(String custId){
        customerIdTxtbox.sendKeys(custId);
    }
    public void clickCustomerRetriveSubmitBtn(){
        customerRetriveSubmitBtn.click();
    }
    public void customerAddress(String address){
        txtCustomerAddress.clear();
        txtCustomerAddress.sendKeys(address);
    }
    public void clickSubmit(){btnSubmit.click();}

}
