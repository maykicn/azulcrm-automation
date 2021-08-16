package com.azulcrm.pages;

import com.azulcrm.utilities.ConfigurationReader;
import com.azulcrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement usernameBox;
    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement passwordBox;
    @FindBy(xpath = "//input[@class='login-btn']")
    public WebElement loginBtn;

    public void login(){

        usernameBox.sendKeys(ConfigurationReader.get("username"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }


}
