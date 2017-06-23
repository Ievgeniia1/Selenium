package com.kit.core.google;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.google.GoogleSearchPage;
import com.kit.pages.google.GoogleSearchResultPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.Assert.assertTrue;

/**
 * Created by evgeniya on 09.06.2017.
 */
@Features("Google search")
@Stories({"WEB-777"})
@Listeners({com.kit.core.TestListener.class})
public class GoogleSearchTest extends WebDriverTestBase {
    private String googleSearch = "https://www.google.com.ua/"; //тестовые данные в начале
    private String searchText = "Selenium";

    @Title("Google search test - positive scenario")
    @Description("Searches any text on google")
    @Test (enabled = true)
    public void searchTest() {
//        GoogleSearchPage googleSearchPage = PageFactory.initElements(webDriver, GoogleSearchPage.class); //для новой страницы
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriver);
        googleSearchPage.open(googleSearch);
        googleSearchPage.fillAndSubmitSearchData(searchText);

        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(webDriver);//Перешли на новую страницу
        //googleSearchResultPage.takeScreenShot(searchText);
        assertTrue(googleSearchResultPage.getLinkText().contains(searchText));

    }


}
