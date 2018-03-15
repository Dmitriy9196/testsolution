package pages;

import blocks.*;
import helpers.enums.Blocks;
import helpers.enums.Filters;
import helpers.Properties;
import org.openqa.selenium.WebDriver;

public class AnalyticsPage {

    private ComparePickersBlock comparePickersBlock;

    private PopularDynamicBlock dynamicBlock;

    private RegionsBlock regionsBlock;

    private RelatedTopicsBlock topicsBlock;

    private RelatedQueriesBlock relatedQueriesBlock;

    public AnalyticsPage(WebDriver driver) {
        this.comparePickersBlock = new ComparePickersBlock(driver);
        this.regionsBlock = new RegionsBlock(driver);
        this.dynamicBlock = new PopularDynamicBlock(driver);
        this.topicsBlock = new RelatedTopicsBlock(driver);
        this.relatedQueriesBlock = new RelatedQueriesBlock(driver);
    }

    public void setFilters(Filters whichFilter, String value) {
        switch (whichFilter){
            case geo:
                comparePickersBlock.setGeoFilter(value);
                break;
            case time:
                comparePickersBlock.setTimeFilter(value);
                break;
            case type:
                comparePickersBlock.setTypeFilter(value);
                break;
            case category:
                comparePickersBlock.setCategoryFilter(value);
                break;
        }
        Properties.customTimeout();
    }

    public void setGeoResolution(String value) {
        regionsBlock.setSubFilter(value);
    }

    public boolean checkErrorWidget(String text) {
        return regionsBlock.hasError(text);
    }

    public void blockShoot(Blocks block) {
        switch (block) {
            case region:
                regionsBlock.blockShoot();
                break;
            case topics:
                topicsBlock.blockShoot();
                break;
            case dynamic:
                dynamicBlock.blockShoot();
                break;
            case queries:
                relatedQueriesBlock.blockShoot();
                break;
        }
    }
}
