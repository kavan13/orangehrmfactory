package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {
    public LoginPage() {PageFactory.initElements(driver, this);}
    @FindBy(xpath = "//input[@id='txtUsername']")
    WebElement username;
    @FindBy (xpath = "//input[@id='txtPassword']")
        WebElement password;
    @FindBy (xpath = "//input[@id='btnLogin']")
        WebElement loginbutton;
    @FindBy (xpath = "//div[@id='logInPanelHeading']")
          WebElement loginpanelText;

    public void selectUserName(String text){sendTextToElement(username,text);}
    public void selectPassword(String text){sendTextToElement(password,text);}
    public void clickOnLoginButton(){
        clickOnElement(loginbutton);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");

    }
    public String getTextLoginPannel(){
        String message= getTextFromElement(loginpanelText);
        CustomListeners.test.log(Status.PASS,"Get Login Pannel");
        return message;
    }

}
