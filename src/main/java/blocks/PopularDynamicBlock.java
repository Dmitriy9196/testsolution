package blocks;

import helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

@Name("Динамика популярности")
public class PopularDynamicBlock {

    private Helper helper;

    @Name("Селектор блока")
    @FindBy(xpath = "//div[@id='TIMESERIES']/parent::div")
    private HtmlElement block;

    public PopularDynamicBlock(WebDriver driver) {
        HtmlElementLoader.populate(this, driver);
        this.helper = new Helper(driver);
    }

    public void blockShoot() {
        helper.scrollToTop();
        helper.takeScreenshot("Dynamic");
    }

}
