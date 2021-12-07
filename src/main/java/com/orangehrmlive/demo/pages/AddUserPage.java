package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends Utility {
    public AddUserPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@id='UserHeading']")
    WebElement addUsersText;
    @FindBy(xpath = "//select[@id='systemUser_userType']")
    WebElement userRoleAdmin;
    @FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
    WebElement ananyaDash;


    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement username;
    @FindBy(xpath = "//select[@id='systemUser_status']")
    WebElement disable;
    // By statusDropDown = By.xpath("//select[@id='systemUser_status']");//valu drop
    @FindBy(xpath = "//input[@id='systemUser_password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
    WebElement confirmPassword;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement saveButton;
    @FindBy(xpath = "//input[@id='btnCancel']")
    WebElement cancleButton;


    public String getTextAddUser() {
        String message = getTextFromElement(addUsersText);
        CustomListeners.test.log(Status.PASS,"Get Text Add User");
        return message;
    }

    public void selectUserRoleAdmin(int value) {
        selectByIndexFromDropDown(userRoleAdmin, value);
        CustomListeners.test.log(Status.PASS,"Enter User RoleAdmin " + value);

    }

    public void selectEmployeananyadash(String text) {
        sendTextToElement(ananyaDash, text);
        CustomListeners.test.log(Status.PASS,"Select Employee " + text);

    }

    public void EnterUserName(String text) {
        sendTextToElement(username, text);
        CustomListeners.test.log(Status.PASS,"Enter User Name " + text);

    }

    public void selectstatus(String text) {
        selectByvalueFromDropDown(disable, text);
        CustomListeners.test.log(Status.PASS,"Select Status" + text);

    }

    public void selectPassword(String text) {
        sendTextToElement(password, text);
        CustomListeners.test.log(Status.PASS,"Select Password" + text);

    }

    public void selectConfirmPassword(String text) {
        sendTextToElement(confirmPassword, text);
        CustomListeners.test.log(Status.PASS,"Select Confirm Password" + text);


    }

    public void selectSaveButtom() {
        clickOnElement(saveButton);
        CustomListeners.test.log(Status.PASS, "Click on Save Button");
    }

    public void selectCancleButtom() {
        clickOnElement(cancleButton);
        CustomListeners.test.log(Status.PASS, "Select Cancle Button");
    }


}
