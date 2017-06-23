package com.kit.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Created by evgeniya on 09.06.2017.
 */
public class GoogleSearchPage extends GoogleBasePage{



    By searchLocator = By.name("q1");
    //@FindBy(name ="q")    //ставится только над єлементом, кот. будем иницицализировать
    private WebElement searchField; //для нужных элементов заводим WebElement и локаторы

    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Attachment(value = "{0}",type = "text/plain")

    @Step ("Put text {0} and click search")
    public void fillAndSubmitSearchData(String searchText){
        searchField = webDriver.findElement(searchLocator); //не нужно т.к есть FindBy
        searchField.sendKeys(searchText);
        searchField.submit();
    }
}
