package com.inetbanking.testcases;


import com.inetbanking.utilitise.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class BaseClass {
    ReadConfig readConfig=new ReadConfig();
    public String baseURL=readConfig.getApplicationURL();
    public String username=readConfig.getUsername();
    public String password= readConfig.getPassword();
    public String customerid=readConfig.getCustomerId();
    public static WebDriver driver;
    public static Logger Log;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser){

        Log = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("Log4j.properties");

        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }
        if(browser.equals("firefox")){
            driver= new FirefoxDriver();
        }
        if(browser.equals("safari")){
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(baseURL);
        Log.info("Browser Opened");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String filename) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Screenshots/"+filename+".png");
        FileUtils.copyFile(source,target);
    }

    public String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(8);
        return generatedString;
    }
}
