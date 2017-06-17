package com.kit.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by evgeniya on 09.06.2017.
 */
public class GoogleSearchPage extends GoogleBasePage{
    //private WebDriver webDriver;  //будет подтягиваться с parent класса
    private WebElement searchField; //для нужных элементов заводим WebElement и локаторы
    By searchLocator = By.name("q");
    //@FindBy (name ="q");





    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
    }



    public void fillAndSubmitSearchData(String searchText){
        searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
    }




}
