package com.kit.thomascook;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Created by evgeniya on 30.06.2017.
 */
public class DragAndDropMy extends WebDriverTestBase {
    @Test
    public void testDragDropMy() throws InterruptedException {
        webDriver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop");
        webDriver.switchTo().frame("iframeResult");

        WebElement From = webDriver.findElement(By.id("drag1"));
        WebElement To = webDriver.findElement(By.id("div1"));

        Actions builder = new Actions(webDriver);
        Action dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
        dragAndDrop.perform();

        From.getAttribute("src").equals("img_logo.gif");        //проверка, что в элементе появился img
    }
}
