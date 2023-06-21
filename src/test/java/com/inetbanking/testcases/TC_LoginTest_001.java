package com.inetbanking.testcases;

import com.inetbanking.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass{
    @Test
    public void loginTest() throws IOException {

        LoginPage lp = new LoginPage(driver);
        lp.setTxtUserName(username);
        Log.info("User Name Entered");
        lp.setTxtPassword(password);
        Log.info("Password Entered");
        lp.clickSubmit();
        /*if(driver.getTitle().equals("Guru 99 Bank Manager Homepage")){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }*/
        Assert.assertEquals(driver.getTitle(),"Guru99 Bank Manager HomePage");
        Log.info("Asserted verfication Done");
        captureScreen(driver,"loginTest");
    }
}
