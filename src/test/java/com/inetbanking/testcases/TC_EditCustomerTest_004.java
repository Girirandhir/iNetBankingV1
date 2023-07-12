package com.inetbanking.testcases;

import com.inetbanking.pageobjects.EditCustomerPage;
import com.inetbanking.pageobjects.LoginPage;
import org.testng.annotations.Test;

public class TC_EditCustomerTest_004 extends BaseClass{
    @Test
    public void editCustomer() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        Thread.sleep(12000);
        lp.setTxtUserName(username);
        lp.setTxtPassword(password);
        lp.clickSubmit();

        EditCustomerPage ecp = new EditCustomerPage(driver);
        ecp.clickEditCustomer();
        ecp.enterValidCustomerId(customerid);
        ecp.clickCustomerRetriveSubmitBtn();

        Thread.sleep(3000);
        ecp.customerAddress("Leicester");
        ecp.clickSubmit();

    }
}
