package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.MyAccountPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.Test;

public class LoginTestCase extends TestBase {

    //object creation
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();


    /*
     * Test case 01
     *  User should navigate to log in page successfully
     */
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on Login link on HomePage
        homePage.clickOnLoginLink();
        //verify text on Login page
        loginPage.verifyTextWelcomePleaseSignIn("Welcome, Please Sign In!");
    }


    /*
     * Test case 02
     * User should log in successfully using valid credentials
     */
    @Test
    public void userShouldLoginSuccessfully() {
        //click Login link on HomePage
        homePage.clickOnLoginLink();

        //send text to email field on LoginPage same email as used for registration
        loginPage.sendTextToEmailField("xyz12@gmail.com");

        //send text to password field on LoginPage
        loginPage.sendTextToPasswordField("abc123");

        //click on login button on LoginPage
        loginPage.clickOnLoginButton();

        //Assert text on MyAccountPage
        myAccountPage.verifyTextMyAccount("My account");
    }
}
