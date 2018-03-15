package blocks.blockparts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class SearchField {

    private Suggestions suggestions;

    @Name("Поисковая строка")
    @FindBy(xpath = "//md-autocomplete-wrap/input")
    private TextInput searchInput;

    public SearchField(WebDriver driver) {
        HtmlElementLoader.populate(this, driver);
        this.suggestions = new Suggestions(driver);
    }

    public void search(String text) {
        searchInput.sendKeys(text);
        suggestions.clickSuggestion(text);
    }
}
