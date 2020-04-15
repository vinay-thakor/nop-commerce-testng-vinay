package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    //list of elements and their locations
    By computerTab = By.xpath("//ul[@class='top-menu notmobile']/li[1]/a");
    By registerLink = By.xpath("//div[@class='header-links-wrapper']//a[contains(text(),'Register')]");
    By logInLink = By.cssSelector("a.ico-login");

    //methods performing actions on elements
    public void clickOnComputerTab() {
        waitUntilPresenceOfElementLocated(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a"),40);

        clickOnElement(computerTab);
    }

    public void clickOnRegisterLink() {
        waitUntilPresenceOfElementLocated(By.xpath("//div[@class='header-links-wrapper']//a[contains(text(),'Register')]"),40);
        clickOnElement(registerLink);
    }

    public void clickOnLoginLink() {
        waitUntilPresenceOfElementLocated(By.cssSelector("a.ico-login"),40);
        clickOnElement(logInLink);
    }
}
