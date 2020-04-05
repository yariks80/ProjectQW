package com.it.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(name = "login")
    private WebElement inputLogin;

    @FindBy(name = "pass")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@tabindex='5']")
    private WebElement btnSubmit;


    protected void login(String login, String password) {
        driver.scrollDown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.scrollUp();
        driver.sendKeysOneByOne(inputLogin, login);
        inputPassword.sendKeys(password);
        btnSubmit.click();
    }


}
