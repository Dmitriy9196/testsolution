package blocks.blockparts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Виджет с ошибкой")
public class ErrorWidget {
    public boolean checkError(WebElement block, String text) {
        String path = "//div[@class='widget-error']";
        return block.findElement(By.xpath(path)).getText().contains(text);
    }
}
