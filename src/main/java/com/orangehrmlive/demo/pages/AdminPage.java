package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends Utility {
    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement clickAdmin;
    @FindBy(xpath = "//a[@id='menu_admin_UserManagement']")
    WebElement userManagement;
    @FindBy(xpath = "//a[@id='menu_admin_Job']")
    WebElement job;

    @FindBy(xpath = "//a[@id='menu_admin_Organization']")
    WebElement organization;

    public void clickOnAdmin() {
        clickOnElement(clickAdmin);
        CustomListeners.test.log(Status.PASS, "Click on Admin");
    }

    public void hoverOnUserManagement() {
        mouseHoverToElement(userManagement);
        CustomListeners.test.log(Status.PASS, "Hover On User Management");
    }

    public void hoverOnJob() {
        mouseHoverToElement(job);
        CustomListeners.test.log(Status.PASS, "Hover On Job");
    }

    public void hoverOnOrganization() {
        mouseHoverToElement(organization);
        CustomListeners.test.log(Status.PASS, "Hover On Organization");
    }

}
