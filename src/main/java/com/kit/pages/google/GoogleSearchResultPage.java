package com.kit.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by evgeniya on 09.06.2017.
 */
public class GoogleSearchResultPage extends GoogleBasePage{

    //private WebDriver webDriver;
    By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
    private WebElement link;

    public GoogleSearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getLinkText(){
        link = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(linkLocator));
        //link=webDriver.findElement(linkLocator);
        return link.getText();
    }
}
