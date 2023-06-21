package com.inetbanking.testcases;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilitise.XLUtils;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass {
    @Test(dataProvider = "LoginData")
    public void loginDDT(String user,String pwd) throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setTxtUserName(user);
        lp.setTxtPassword(pwd);
        lp.clickSubmit();
        Thread.sleep(3000);
        if(isAlertPresent()){
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertFalse(true);
        }
        else{
           Assert.assertTrue(true);
           lp.clickLogout();
           Thread.sleep(3000);
           driver.switchTo().alert().accept();
           driver.switchTo().defaultContent();
        }
    }

    public boolean isAlertPresent(){
        try {
            driver.switchTo().alert();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @DataProvider(name="LoginData")
    String [][] getData() throws IOException {
        String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/UserDetails.xlsx";
        int rownum= XLUtils.getRowCount(path,"Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);

        String logindata[][]= new String[rownum][colcount];
        for(int i=1;i<=rownum;i++){
            for(int j=0;j<colcount;j++){
                logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
            }
        }
        return logindata;
    }

}
