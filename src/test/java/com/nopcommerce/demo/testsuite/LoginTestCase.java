package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.loadproperty.Loadproperty;
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
    Loadproperty loadproperty = new Loadproperty();
    String email = loadproperty.getProperty("email");
    String password = loadproperty.getProperty("password");
    String invalidEmail = loadproperty.getProperty("invalidEmail");



    /*
     * Test case 01
     *  User should navigate to log in page successfully
     */
    @Test(priority = 0,groups = {"Sanity","Regression"})
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
    @Test(priority = 1,groups = {"Sanity","Regression"})
    public void userShouldLoginSuccessfully() {
        //click Login link on HomePage
        homePage.clickOnLoginLink();

        //send text to email field on LoginPage same email as used for registration
        loginPage.sendTextToEmailField(email);

        //send text to password field on LoginPage
        loginPage.sendTextToPasswordField(password);

        //click on login button on LoginPage
        loginPage.clickOnLoginButton();

        //Assert text on MyAccountPage
        myAccountPage.verifyTextMyAccount("My account");
    }
    // test 3
    @Test(priority = 2,groups = {"Sanity","Regression"})
    public void userShouldNotLoginSuccessfullyWithInvalidCredentials(){
        //click Login link on HomePage
        homePage.clickOnLoginLink();

        //send text to invalidemail field on LoginPage same email as used for registration
        loginPage.sendTextToEmailField(invalidEmail);

        //send text to password field on LoginPage
        loginPage.sendTextToPasswordField(password);

        //click on login button on LoginPage
        loginPage.clickOnLoginButton();

        //Assert text on MyAccountPage login Unsuccessful
        loginPage.verifyLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");
















    }
}
