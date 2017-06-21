package com.kit.core.gmail;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;

/**
 * Created by evgeniya on 09.06.2017.
 */
public class gmailOldTest extends WebDriverTestBase{

   @Test (enabled = true)
    public void mailTest(){
        //webDriver.findElement(By.className("gmail-nav__nav-link gmail-nav__nav-link__sign-in")).click();
        String searchText= "Gmail";

        String myPassword = "2wsxzaq1";

        webDriver.get("https://gmail.com");
        WebElement gmailText = webDriver.findElement(By.id("headingSubtext"));
        //assertTrue(gmailText.getText().contains(searchText));

        webDriver.findElement(By.id("identifierId")).sendKeys("testselenium373");
        webDriver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
        WebElement password = webDriver.findElement(By.name("password"));
        password.sendKeys(myPassword);
        password.sendKeys(Keys.RETURN);
//        WebElement button = webDriver.findElement(By.id("passwordNext"));
//        button.click();


        WebElement mailText = webDriver.findElement(By.xpath(".//*[@id=':3c']/span"));


        assertTrue(mailText.getText().contains(searchText));




    }



}
