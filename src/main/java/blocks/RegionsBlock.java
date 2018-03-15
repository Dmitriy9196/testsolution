package blocks;

import blocks.blockparts.ErrorWidget;
import helpers.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


@Name("Популярность по регионам")
public class RegionsBlock  {

    private Helper helper;

    private ErrorWidget errorWidget;

    @Name("Селектор блока")
    @FindBy(xpath = "//div[@id='GEO_MAP']/parent::div")
    private HtmlElement block;

    @Name("Суб-фильтр регион/город")
    @FindBy(xpath = "//md-select[@md-container-class='geo-resolution']//md-select-value")
    private HtmlElement geoFilter;

    @Name("Опции для фильтра")
    @FindBy(xpath = "//div[contains(@class, 'geo-resolution')]/md-select-menu")
    private HtmlElement geoOptions;



    public RegionsBlock(WebDriver driver){
        HtmlElementLoader.populate(this, driver);
        this.errorWidget = new ErrorWidget();
        this.helper = new Helper(driver);
    }

    public void setSubFilter(String value) {
        geoFilter.click();
        String optionPath = "//div[normalize-space() = '%s']/parent::md-option";
        geoOptions.findElement(By.xpath(String.format(optionPath,value))).click();
    }

    public boolean hasError(String text) {
        return errorWidget.checkError(block, text);
    }

    public void blockShoot(){
        helper.scrollToElement(block);
        helper.takeScreenshot("RegionsBlock");
    }
}
