package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//body/div[@id='wrapper']/div[@id='branding']/a[1]/img[1]")
    WebElement orangehrmlogo;
    @FindBy (xpath = "//b[normalize-space()='Admin']")
           WebElement admin;
    @FindBy (xpath = "//b[normalize-space()='PIM']")
           WebElement pim;
    @FindBy (xpath = "//b[normalize-space()='Leave']")
           WebElement leave;
    @FindBy (xpath = "//b[normalize-space()='Dashboard']")
           WebElement dadhboard;
    @FindBy (xpath = "//a[@id='welcome']")
           WebElement welcometext;
    @FindBy (xpath = "//a[contains(text(),'Logout')]")
           WebElement logout;


    public String OrangeHRMLogo(){
        String message =getTextFromElement(orangehrmlogo);
        CustomListeners.test.log(Status.PASS,"Get Login Pannel");
        return message;
    }
    public void clickOnAdmin(){clickOnElement(admin);
        CustomListeners.test.log(Status.PASS,"Click on Admin");
    }
    public void clickOnPim(){clickOnElement(pim);
        CustomListeners.test.log(Status.PASS,"Click on Pim");
    }
    public void clickOnLeave(){clickOnElement(leave);
        CustomListeners.test.log(Status.PASS,"Click on Leave");
    }
    public void clickOnDashboard(){clickOnElement(dadhboard);
        CustomListeners.test.log(Status.PASS,"Click on Dashboard");
    }
    public void clickOnWelcomeUser(){clickOnElement(welcometext);
        CustomListeners.test.log(Status.PASS,"Click on Welcome User");
    }
    public void clickOnLogOutLink(){mouseHoverAndClickToElement(logout);
        CustomListeners.test.log(Status.PASS,"Click on logout Link");
    }
    public String getTextWelcome(){
        String message =getTextFromElement(welcometext);
        CustomListeners.test.log(Status.PASS,"Get Text Welcom");
        return message;}


}
