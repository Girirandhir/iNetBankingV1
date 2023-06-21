package com.inetbanking.testcases;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC_AddCustomerTest_003 extends BaseClass{
    @Test
    public void addNewCustomer() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        Thread.sleep(12000);
        lp.setTxtUserName(username);
        lp.setTxtPassword(password);
        lp.clickSubmit();



        AddCustomerPage addCustomer = new AddCustomerPage(driver);
        addCustomer.clickAddNewCustomer();
        Thread.sleep(5000);
        addCustomer.customerName("John");
        addCustomer.selectCustomerGender("male");
        addCustomer.setCustomerDOB("10","12","2001");
        addCustomer.customerAddress("INDIA");
        addCustomer.customerCity("PUNE");
        addCustomer.customerState("MAHA");
        addCustomer.customerPinNo("411000");
        addCustomer.customerTelephone("12398912");
        addCustomer.customerEmailId(randomString()+"@gmail.com");
        addCustomer.customerPassword("pass@1234");
        addCustomer.clickSubmit();



        Assert.assertTrue(driver.getPageSource().contains("Customer Registered Successfully!!!"));

    }


}
