package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.AdminPage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUsersPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class UsersTest extends TestBase {

    LoginPage loginPage;
    ViewSystemUsersPage viewSystemUsersPage;
    AdminPage adminPage;
    AddUserPage addUserPage;
    @BeforeMethod
    public void inIt() {
         loginPage = new LoginPage();
         viewSystemUsersPage = new ViewSystemUsersPage();
         adminPage = new AdminPage();
         addUserPage = new AddUserPage();

    }
    @Test (groups = {"smoke","sanity","regression"})
    public void adminShouldAdduserSuccessFully() throws InterruptedException {
        loginPage.selectUserName("Admin");
        loginPage.selectPassword("admin123");
        loginPage.clickOnLoginButton();
        Thread.sleep(1000);
        adminPage.clickOnAdmin();
        Thread.sleep(1000);
        String expectedMessage1 = viewSystemUsersPage.getTextsystemUser();
        String actualMessage1 = viewSystemUsersPage.getTextsystemUser();
        Assert.assertEquals(actualMessage1, expectedMessage1, "verify Text");
        Thread.sleep(1000);
        viewSystemUsersPage.clickOnAddButton();

        String expectedMessage2 = "Add User";
        String actualMessage2 = addUserPage.getTextAddUser();
        Assert.assertEquals(expectedMessage2, actualMessage2, "verify Text");
        Thread.sleep(1000);
        addUserPage.selectUserRoleAdmin(0);
        addUserPage.selectEmployeananyadash("Ananya Dash");
        addUserPage.EnterUserName("Kavan123");
        Thread.sleep(1000);
        addUserPage.selectstatus("0");
        addUserPage.selectPassword("Abcd123@");
        addUserPage.selectConfirmPassword("Abcd123@");
        addUserPage.selectSaveButtom();

    }
    @Test (groups = {"sanity","regression"})
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        this.adminShouldAdduserSuccessFully();
        Thread.sleep(1000);
        viewSystemUsersPage.selectUsernameField("Kavan123");
        viewSystemUsersPage.selectUserRollDropDown(1);
        Thread.sleep(1000);
        viewSystemUsersPage.selectStatusDropDown(2);
        viewSystemUsersPage.clickOnSearchButton();
        String expectedMessage2 = "Kavan123";
        String actualMessage2 = viewSystemUsersPage.getVerifyUserResult();
        Assert.assertEquals(actualMessage2, expectedMessage2, "verify Text");


    }
    @Test (groups = {"smoke","sanity","regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {
        this.adminShouldAdduserSuccessFully();
        viewSystemUsersPage.selectUsernameField("Kavan123");
        viewSystemUsersPage.selectUserRollDropDown(1);
        viewSystemUsersPage.selectStatusDropDown(2);
        viewSystemUsersPage.clickOnSearchButton();
        viewSystemUsersPage.clickOnCheckBox();
        viewSystemUsersPage.clickOndeleteButton();
        viewSystemUsersPage.clickOnPopUpButton();

    }
    @Test (groups = {"regression1","regression"})
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound(){
        loginPage.selectUserName("Admin");
        loginPage.selectPassword("admin123");
        loginPage.clickOnLoginButton();
        adminPage.clickOnAdmin();
        String expectedMessage1 = viewSystemUsersPage.getTextsystemUser();
        String actualMessage1 = viewSystemUsersPage.getTextsystemUser();
        Assert.assertEquals(actualMessage1, expectedMessage1, "verify Text");
        viewSystemUsersPage.selectUsernameField("Kavan123");
        viewSystemUsersPage.selectUserRollDropDown(1);
        viewSystemUsersPage.selectStatusDropDown(2);
        viewSystemUsersPage.clickOnSearchButton();

        String expectedMessage2 = "No Records Found";
        String actualMessage2 = viewSystemUsersPage.getVerifyNoRecordFound();
        Assert.assertEquals(actualMessage2,expectedMessage2, "verify Text");

    }
}