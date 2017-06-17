package com.kit.core.google;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by evgeniya on 02.06.2017.
 */
public class GoogleSearchOldTest extends WebDriverTestBase{
    private String googleSearch = "https://www.google.com.ua/";


    @Test (enabled = false)
    public void searchTest(){
        webDriver.get(googleSearch);
        String searchText = "Selenium";

        By searchLocator = By.name("q");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);;
        searchField.submit();


        By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
        WebElement link = webDriver.findElement(linkLocator);

        assertTrue(link.getText().contains(searchText));


    }

}
