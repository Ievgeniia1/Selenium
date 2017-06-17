package com.kit.pages.gmailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by evgeniya on 09.06.2017.
 */
public class UserNamePage{
    private WebDriver webDriver;
    private WebElement userNameField;
    By userNameLocator = By.id("identifierId");

    private WebElement nextButton;
    By nextButtonLocator = By.xpath(".//*[@id='identifierNext']/content/span");


    public UserNamePage(WebDriver webDriver) {
        this.webDriver=webDriver;
    }

    public void open(String url){
        webDriver.get(url);
    }

    public void putName(String userName) {
        userNameField = webDriver.findElement(userNameLocator);
        userNameField.sendKeys(userName);
    }

    public void clickNext(){
    nextButton = webDriver.findElement(nextButtonLocator);
    nextButton.click();
    }

}
