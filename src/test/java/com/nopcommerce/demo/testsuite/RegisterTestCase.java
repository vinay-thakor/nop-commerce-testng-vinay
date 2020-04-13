package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.loadproperty.Loadproperty;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.nopcommerce.demo.utility.Utility.getRandomString;

public class RegisterTestCase extends TestBase {

    static String email = null;





    //object creation
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    RegistrationCompletePage registrationCompletePage = new RegistrationCompletePage();
    Loadproperty loadproperty = new Loadproperty();
    String firstName = loadproperty.getProperty("firstName");
    String lastName = loadproperty.getProperty("lastName");
    String password = loadproperty.getProperty("password");
    String companyName = loadproperty.getProperty("companyName");
    String dayOB = loadproperty.getProperty("dayOB");
    String monthOB = loadproperty.getProperty("monthOB");
    String yearOB = loadproperty.getProperty("yearOB");






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
    @Test(priority = 0,groups = {"Sanity","Regression"})
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
    @Test(priority = 1,groups = {"Smoke","Regression"})
    public void userShouldRegisterSuccessfullyAndLoginUsingSameCredentials() {
        //click on Register link on HomePage
        homePage.clickOnRegisterLink();

        //select Male gender radio button
        registerPage.selectMaleGenderRadioButton();

        //select Female gender radio button
        //registerPage.selectFemaleGenderRadioButton();

        //send text to First Name field
        registerPage.sendTextToFirstNameField(loadproperty.getProperty(firstName));

        //send text to Last Name field
        registerPage.sendTextToLastNameField(lastName);

        //select day from DOB drop down menu
        registerPage.selectDayDOBFromDropDownMenu(dayOB);

        //select month from DOB drop down menu
        registerPage.selectMonthDOBFromDropDownMenu(monthOB);

        //select year from DOB drop down menu
        registerPage.selectYearDOBFromDropDownMenu(yearOB);

        //send text to Email field
        registerPage.sendTextToEmailField(email);

        //send text to Company name field
        registerPage.sendTextToCompanyField(companyName);

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
