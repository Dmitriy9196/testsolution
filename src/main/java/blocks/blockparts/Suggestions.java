package blocks.blockparts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class Suggestions {

    private WebDriver driver;

    public Suggestions(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }
    public void clickSuggestion(String searchText) {
        String path = "//div[contains(normalize-space(), '%s')]/ancestor::li";
        Button suggestion = new Button(driver.findElement(By.xpath(String.format(path, searchText))));
        suggestion.click();
    }
}
