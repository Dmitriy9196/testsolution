package pages;

import blocks.blockparts.SearchField;
import org.openqa.selenium.WebDriver;

public class TrendsPage {

    private WebDriver driver;

    private SearchField searchField;

    public TrendsPage(WebDriver driver) {
        this.searchField = new SearchField(driver);
        this.driver = driver;
    }

    public void search(String text) {
        searchField.search(text);
    }

    public void openPage () {
        String pageUrl = "https://trends.google.ru/trends/";
        driver.get(pageUrl);
    }
}
