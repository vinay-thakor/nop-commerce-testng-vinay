package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.nopcommerce.demo.utility.Utility.getRandomString;

public class RegisterTestCase extends TestBase {

    static String email = null;
    String password = "abc123";


    //object creation
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    RegistrationCompletePage registrationCompletePage = new RegistrationCompletePage();


    //assigning random value for email every time test cases run
    @BeforeTest
    public static void setUp() {
        email = "xyz" + getRandomString(5) + "@gmail.com";
    }


    /*
      Test Case 1
      User should navigate to register page successfully.
      Click on Register Link
      Message   “Your Personal Details“
      Assert above message.
    */
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //click on Register link on HomePage
        homePage.clickOnRegisterLink();
        //Assert text on RegistrationPage
        registerPage.verifyTextYourPersonalDetails("Your Personal Details");
    }


    /*
        Test Case 2
        User should register successfully.
        Click on Register
        Enter correct details in field
        Click on register  button.
        Expected Result:
        Success Message  “Your registration completed”
        Assert above message.
    */
    @Test
    public void userShouldRegisterSuccessfullyAndLoginUsingSameCredentials() {
        //click on Register link on HomePage
        homePage.clickOnRegisterLink();

        //select Male gender radio button
        registerPage.selectMaleGenderRadioButton();

        //select Female gender radio button
        //registerPage.selectFemaleGenderRadioButton();

        //send text to First Name field
        registerPage.sendTextToFirstNameField("Prime");

        //send text to Last Name field
        registerPage.sendTextToLastNameField("Testing");

        //select day from DOB drop down menu
        registerPage.selectDayDOBFromDropDownMenu("15");

        //select month from DOB drop down menu
        registerPage.selectMonthDOBFromDropDownMenu("May");

        //select year from DOB drop down menu
        registerPage.selectYearDOBFromDropDownMenu("2014");

        //send text to Email field
        registerPage.sendTextToEmailField(email);

        //send text to Company name field
        registerPage.sendTextToCompanyField("Square 1");

        //check Newsletter checkbox is selected
        registerPage.selectNewsLetterCheckBox();

        //send text to Password field
        registerPage.sendTextToPasswordField(password);

        //send text to Confirm password field
        registerPage.sendTextToConfirmPasswordField(password);

        //click Register button
        registerPage.clickOnRegisterButton();

        //Assert text Registration complete page
        registrationCompletePage.verifyTextYourRegistrationCompleted("Your registration completed");

    }
}
