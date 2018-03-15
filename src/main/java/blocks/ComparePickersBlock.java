package blocks;

import blocks.blockparts.Options;
import blocks.blockparts.Suggestions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;

// Такие же большие локаторы, как гробы для верставших
public class ComparePickersBlock {

    private Suggestions suggestions;

    private Options options;

    @Name("фильтр по категориям")
    @FindBy(xpath = "//hierarchy-picker[@track-name='CategoryPicker']")
    private HtmlElement categoryPicker;

    @Name("Фильтр по миру")
    @FindBy(xpath = "//hierarchy-picker[@track-name='geoPicker']//div[@role='button']")
    private HtmlElement geoPicker;

    @Name("Фильтр по времени и по типу поиска")
    @FindBy(xpath = "//div[contains(@class, 'compare-pickers')]//md-select")
    private List<HtmlElement> timeAndTypeFilter;

    @Name("Поисковые строка")
    @FindBy(xpath = "//div[@class = 'hierarchy-autocomplete']//input")
    private TextInput textInput;


    public ComparePickersBlock(WebDriver driver) {
        HtmlElementLoader.populate(this, driver);
        this.suggestions = new Suggestions(driver);
        this.options = new Options(driver);
    }

    public void setCategoryFilter(String value) {
        categoryPicker.click();
        textInput.sendKeys(value);
        suggestions.clickSuggestion(value);
    }

    public void setGeoFilter(String value) {
        geoPicker.click();
        textInput.sendKeys(value);
        suggestions.clickSuggestion(value);
    }

    public void setTimeFilter(String value) {
        timeAndTypeFilter.get(0).click();
        options.selectOption(value);
    }

    public void setTypeFilter(String value) {
        timeAndTypeFilter.get(1).click();
        options.selectOption(value);
    }

}
