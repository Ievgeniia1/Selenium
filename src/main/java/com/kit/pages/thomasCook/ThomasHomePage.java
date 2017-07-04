package com.kit.pages.thomasCook;

import com.kit.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by evgeniya on 30.06.2017.
 */
public class ThomasHomePage {
    private WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;


    WebElement dropdown;
    By dropdownId = By.id("SearchbarForm-duration");

    public ThomasHomePage(WebDriver webDriver) {
        this.webDriver=webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);
    }
    @Step("I open given url")
    public void open(String url){
    webDriver.get(url);
}

    @Step ("I select option from dropdown")
    public void selectFromDropdown (String value){
        dropdown=webDriver.findElement(dropdownId);
        Select selObj = new Select(dropdown);
        selObj.selectByValue(value);
}

    @Step("Get text from selected option")
    public String getText (){
        Select selObj = new Select(dropdown);
        String text = selObj.getFirstSelectedOption().getText();
        return text;

    }
}
