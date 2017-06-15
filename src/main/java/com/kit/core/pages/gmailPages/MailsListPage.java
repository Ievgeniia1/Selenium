package com.kit.core.pages.gmailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by evgeniya on 09.06.2017.
 */
public class MailsListPage {
    private WebDriver webDriver;
    WebElement searchText;
    By textLocator = By.xpath(".//*[@id=':3c']/span");

    public MailsListPage(WebDriver webDriver) {
        this.webDriver=webDriver;
    }


    public String getMailText(){
        searchText = webDriver.findElement(textLocator);
        return searchText.getText();

    }

}
