package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends Utility {
    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//h1[normalize-space()='Dashboard']")
    WebElement dashboardtext;
    @FindBy (xpath = "//span[normalize-space()='Assign Leave']")
           WebElement aasignleave;
    @FindBy (xpath = "//span[normalize-space()='Leave List']")
           WebElement leaveList;
    @FindBy (xpath = "//span[normalize-space()='Timesheets']")
           WebElement timesheets;
    @FindBy (xpath = "//span[normalize-space()='Apply Leave']")
           WebElement applyLeave;
    @FindBy (xpath = "//span[normalize-space()='My Leave']")
           WebElement myleave;
    @FindBy (xpath = "//span[normalize-space()='My Timesheet']")
          WebElement  mytimesheet;


    public String getTextDashBoard(){return getTextFromElement(dashboardtext);}
    public void clickOnAAsignLeave(){clickOnElement(aasignleave);}
    public void clickOnLeaveList(){clickOnElement(leaveList);}
    public void clickOnTimeSheets(){clickOnElement(timesheets);}
    public void clickOnApplyLavae(){clickOnElement(applyLeave);}
    public void clickOnMyLeave(){clickOnElement(myleave);}
    public void clickOnMyTimeSheet(){clickOnElement(mytimesheet);}

}
