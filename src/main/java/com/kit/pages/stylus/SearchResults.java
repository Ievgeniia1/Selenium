package com.kit.pages.stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by evgeniya on 19.06.2017.
 */
public class SearchResults {
    WebDriver myDriver;
    private WebElement link;
    By linkLocator = By.cssSelector(".item.out-of-stock");

    public SearchResults(WebDriver myDriver) {
        this.myDriver=myDriver;
    }

    public String getLinkText(){
        link=myDriver.findElement(linkLocator);
        return link.getText();
    }

    public void click(){
        link=myDriver.findElement(linkLocator);
        link.click();
    }

}
