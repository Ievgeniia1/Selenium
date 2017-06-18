package com.kit.core.stylus;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.stylus.ItemCard;
import com.kit.pages.stylus.MainPage;
import com.kit.pages.stylus.SearchResults;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by evgeniya on 19.06.2017.
 */
public class StylusNewTest extends WebDriverTestBase {
    //test data
    String url = "http://stylus.com.ua/";
    String searchText = "Sony Z2";
    String containText1 ="Sony";
    String containText2 = "Z2";
    String code = "Код товара";


    @Test
    public void test(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open(url);
        mainPage.search(searchText);

        SearchResults searchResults = new SearchResults(webDriver);
        assertTrue(searchResults.getLinkText().contains(containText1));
        assertTrue(searchResults.getLinkText().contains(containText2));
        searchResults.click();


        ItemCard itemCard = new ItemCard(webDriver);

        assertTrue(itemCard.getText().contains(code));


    }

}
