package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt2() {
        homePage = new HomePage();
        loginPage = new LoginPage();

    }
    @Test (groups = {"smoke","sanity","regression"})
    public void verifyUserShouldLoginSuccessfully() throws InterruptedException {

        loginPage.selectUserName("Admin");
        loginPage.selectPassword("admin123");
        Thread.sleep(1000);
        loginPage.clickOnLoginButton();
        String expectedMessage1 = "Welcome Lich";
        String actualMessage1 = homePage.getTextWelcome();
        Assert.assertEquals(expectedMessage1, actualMessage1, "Text Verify");
    }
    @Test (groups = {"sanity","regression"})
    public void verifyThatLogoDisplayOnHomePage() throws InterruptedException {
        this.verifyUserShouldLoginSuccessfully();
        String expectedLogo = homePage.OrangeHRMLogo();
        String actualLogo = homePage.OrangeHRMLogo();
        Assert.assertEquals(actualLogo,expectedLogo);


    }
    @Test (groups = {"regression1","regression"} )
    public void verifyUserShouldLogOutSuccessfully() throws InterruptedException {
        this.verifyUserShouldLoginSuccessfully();
      //  Thread.sleep(1000);
        homePage.clickOnWelcomeUser();
        Thread.sleep(500);
        homePage.clickOnLogOutLink();
        Thread.sleep(1000);
        String expectedMessage1 = "LOGIN Panel";
        String actualMessage1 = loginPage.getTextLoginPannel();
        Assert.assertEquals(actualMessage1, expectedMessage1, "Text Verify");



    }
}
