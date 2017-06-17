package com.kit.pages.gmailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by evgeniya on 09.06.2017.
 */
public class PasswordPage {
    private WebDriver webDriver;
    private WebElement passwordField;
    private WebElement nextButton;
    By passwordLocator = By.name("password");
    By buttonLocator = By.id("passwordNext");

    public PasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillPassword(String password){
        passwordField = webDriver.findElement(passwordLocator);
        passwordField.sendKeys(password);

        nextButton = webDriver.findElement(buttonLocator);
        nextButton.click();
        //or
        //passwordField.sendKeys(Keys.RETURN); //means click Enter key to submit
    }


}
