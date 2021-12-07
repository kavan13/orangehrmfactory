package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewSystemUsersPage extends Utility {
    public ViewSystemUsersPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='systemUser-information']//a[@href='#']")
    WebElement systemUsersText;////a[contains(text(),'>')]
    @FindBy(xpath = "//input[@id='searchSystemUser_userName']")
    WebElement userNameField;
    @FindBy(xpath = "//select[@id='searchSystemUser_userType']")
    WebElement userRoll;
    @FindBy(xpath = "//input[@id='searchSystemUser_employeeName_empName']")
    WebElement employNameField;

    @FindBy(xpath = "//select[@id='searchSystemUser_status']")
    WebElement statusDropDown;
    @FindBy(xpath = "//input[@id='searchBtn']")
    WebElement searchButton;
    @FindBy(xpath = "//input[@id='resetBtn']")
    WebElement resetButton;
    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addButton;
    @FindBy(xpath = "//input[@id='btnDelete']")
    WebElement deleteButton;
    @FindBy(xpath = "//input[@name='chkSelectRow[]']")
    WebElement checkBox;
    @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
    WebElement popUpButton;
    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    WebElement verifyUserResult;
    @FindBy(xpath = "//td[contains(text(),'No Records Found')]")
    WebElement noRecordMsg;

    public String getTextsystemUser() {
        String message = getTextFromElement(systemUsersText);
        CustomListeners.test.log(Status.PASS, "Get Text System User");
        return message;
    }

    public void selectUsernameField(String text) {
        sendTextToElement(userNameField, text);
        CustomListeners.test.log(Status.PASS,"Enter User Name Field " + text);

    }

    public void selectUserRollDropDown(int value) {
        selectByIndexFromDropDown(userRoll,value);
        CustomListeners.test.log(Status.PASS,"Select User Roll " + value);

    }

    public void selectEmployNameField(String value) {
        selectByvalueFromDropDown(employNameField, value);
        CustomListeners.test.log(Status.PASS,"Select Employee Name " + value);

    }

    public void selectStatusDropDown(int value) {
        selectByIndexFromDropDown(statusDropDown, value);
        CustomListeners.test.log(Status.PASS,"Select Status " + value);

    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
        CustomListeners.test.log(Status.PASS,"Click on Search Button");

    }

    public void clickOnrestButton() {
        clickOnElement(resetButton);
        CustomListeners.test.log(Status.PASS,"Click on Rest Button");

    }

    public void clickOnAddButton() {
        clickOnElement(addButton);
        CustomListeners.test.log(Status.PASS,"Click on Add Button");

    }

    public void clickOndeleteButton() {
        clickOnElement(deleteButton);
        CustomListeners.test.log(Status.PASS,"Click on Delete Button");

    }

    public void clickOnCheckBox() {
        clickOnElement(checkBox);
        CustomListeners.test.log(Status.PASS,"Click on Check Box");

    }

    public void clickOnPopUpButton() {
        clickOnElement(popUpButton);
        CustomListeners.test.log(Status.PASS,"Click on PopUp Button");

    }

    public String getVerifyUserResult() {
        String message = getTextFromElement(verifyUserResult);
        CustomListeners.test.log(Status.PASS, "Get Text User Result");
        return message;

    }

    public String getVerifyNoRecordFound() {
        String message = getTextFromElement(noRecordMsg);
        CustomListeners.test.log(Status.PASS, "Get Text No Record Found");
        return message;

    }


}
