package blocks;

import blocks.blockparts.SearchField;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.annotations.Name;

@Name("Блок с поисковой строкой")
public class ExplorePillsBlock {

    private SearchField searchField;

    public ExplorePillsBlock(WebDriver driver) {
        this.searchField = new SearchField(driver);
    }

    public void changeSearch(String text) {
        searchField.search(text);
    }
}
