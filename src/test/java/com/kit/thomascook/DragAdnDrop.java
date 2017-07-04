package com.kit.thomascook;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by evgeniya on 30.06.2017.
 */
public class DragAdnDrop extends WebDriverTestBase {
    @Test
    public void testDragDrop() throws InterruptedException {
        webDriver.get("https://gojs.net/latest/samples/htmlDragDrop.html?gclid=CLjWnLeG5tQCFUeVGwodCowEcA");
        WebElement From = webDriver.findElement(By.xpath(".//*[@id='sample']/div[1]/span[1]/div/div[1]"));
        WebElement To = webDriver.findElement(By.xpath(".//*[@id='myDiagramDiv']/canvas"));
        Actions builder = new Actions(webDriver);
        builder.clickAndHold(From).moveToElement(To).release(To).build().perform();
    }

}
