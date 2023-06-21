package com.inetbanking.utilitise;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Reporting extends TestListenerAdapter {
    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    public void onStart(ITestContext testContext){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName="Test-Report-"+timeStamp+".html";

        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
        try {
            htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        extent= new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name","localhost");
        extent.setSystemInfo("environment","QA");
        extent.setSystemInfo("user","QATeamAssociate");

        htmlReporter.config().setDocumentTitle("Inet Banking Test Report");
        htmlReporter.config().setReportName("Functional Test Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onTestSuccess(ITestResult testResult){
        logger=extent.createTest(testResult.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));
    }
    public void onTestFailure(ITestResult testResult){
        logger=extent.createTest(testResult.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName(), ExtentColor.RED));

        String screenShotPathName = System.getProperty("user.dir")+"\\ScreenShots\\"+testResult.getName()+".png";

        File fileName = new File(screenShotPathName);

        if(fileName.exists()){
            try{
                logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenShotPathName));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void onTestSkipped(ITestResult testResult){
        logger=extent.createTest(testResult.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(testResult.getName(), ExtentColor.ORANGE));
    }
    public void onFinish(ITestContext testContext){
        extent.flush();
    }
}
