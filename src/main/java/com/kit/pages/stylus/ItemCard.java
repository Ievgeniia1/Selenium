package com.kit.pages.stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by evgeniya on 19.06.2017.
 */
public class ItemCard {
    WebDriver myDriver;
    WebElement itemCode;
    By code = By.xpath(".//*[@id='product-block']/header/div[1]/span");

    public ItemCard(WebDriver myDriver) {
        this.myDriver =myDriver;
    }
    public String getText(){
        itemCode=myDriver.findElement(code);
        return itemCode.getText();
    }
}
