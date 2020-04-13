package com.nopcommerce.demo.testbase;

import com.nopcommerce.demo.basepage.BasePage;
import com.nopcommerce.demo.browserselector.BrowserSelector;
import com.nopcommerce.demo.loadproperty.Loadproperty;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase extends BasePage {

    //object creation
    BrowserSelector browserSelector = new BrowserSelector();
    Loadproperty loadproperty = new Loadproperty();

    //geting "baseUrl" & "browser" value from config.pro
    String baseUrl = loadproperty.getProperty("baseUrl");
    String browser = loadproperty.getProperty("browser");


    //open browser
    @BeforeMethod(groups = {"Sanity","Smoke","Regression"})
    public void openBrowser() {
        browserSelector.selectBrowser(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    //close browser
    @AfterMethod(groups = {"Sanity","Smoke","Regression"})
    public void closeBrowser() {
        driver.quit();
    }

}
