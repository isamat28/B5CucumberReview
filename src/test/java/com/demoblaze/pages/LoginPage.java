package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "login2")
    public WebElement loginHomePage_Loc;

    @FindBy(id = "loginusername")
    public WebElement username_Loc;

    @FindBy(id = "loginpassword")
    public WebElement password_Loc;

    @FindBy(css = "[onclick='logIn()']")
    public WebElement loginBtn_Loc;

    @FindBy(id = "nameofuser")
    public WebElement welcomeUsername_loc;

    public void login_mtd(){
        String username= ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        loginHomePage_Loc.click();
        username_Loc.sendKeys(username);
        password_Loc.sendKeys(password);
        loginBtn_Loc.click();
        BrowserUtils.waitFor(2);

    }
    public void verifyWelcomeMessage_mtd(String expectedMessage){
        String actualMessage = welcomeUsername_loc.getText();
        Assert.assertEquals("username does NOT match",actualMessage,expectedMessage);
    }
    public void loginWithParameter_mtd(String username,String password){
        BrowserUtils.waitForClickablility(loginHomePage_Loc,2).click();
        //loginHomePage_Loc.click();
        username_Loc.sendKeys(username);
        password_Loc.sendKeys(password);
        loginBtn_Loc.click();
        BrowserUtils.waitFor(2);
    }
}
