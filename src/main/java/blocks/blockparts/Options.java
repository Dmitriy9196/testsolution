package blocks.blockparts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class Options {

    @Name("Опции для фильтров")
    @FindBy(tagName = "md-option")
    private HtmlElement option;

    public Options(WebDriver driver) {
        HtmlElementLoader.populate(this, driver);
    }

    public void selectOption(String value) {
        String path = "//div[normalize-space() ='%s']/parent::*";
        option.findElement(By.xpath(String.format(path, value)));
        option.click();
    }
}
