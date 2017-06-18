package com.kit.pages.stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by evgeniya on 19.06.2017.
 */
public class MainPage {
    private WebDriver myDriver;
    private WebElement  inputField;
    By inputLocator = By.name("q");
    private WebElement searchButton;
    By button = By.xpath(".//*[@id='head-search']/form/input[2]");

    public MainPage(WebDriver myDriver) {
        this.myDriver=myDriver;

    }

    public void open(String url){
        myDriver.get(url);
    }



    public void search(String searchText){
        inputField=myDriver.findElement(inputLocator);
        inputField.sendKeys(searchText);
        searchButton=myDriver.findElement(button);
        searchButton.click();
    }
}
