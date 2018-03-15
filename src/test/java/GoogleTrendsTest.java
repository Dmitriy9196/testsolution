import helpers.enums.Blocks;
import helpers.enums.Filters;
import helpers.Helper;
import helpers.Properties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.AnalyticsPage;
import pages.TrendsPage;

public class GoogleTrendsTest {

    private static WebDriver driver;

    private static TrendsPage trendsPage;

    private static AnalyticsPage analyticsPage;

    @BeforeClass
    public static void setUp () {
        driver = Properties.makeSettings();
        trendsPage = new TrendsPage(driver);
        analyticsPage = new AnalyticsPage(driver);
        Helper.makeReportFolder();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


    @Test
    public void search() {
        trendsPage.openPage();
        trendsPage.search("Точка Банк");
        analyticsPage.setFilters(Filters.geo, "Россия");
        analyticsPage.setGeoResolution("Город");
        analyticsPage.blockShoot(Blocks.dynamic);
        analyticsPage.blockShoot(Blocks.queries);
        analyticsPage.blockShoot(Blocks.region);
        analyticsPage.blockShoot(Blocks.topics);
        analyticsPage.setFilters(Filters.geo, "Уганда");
        Assert.assertTrue(analyticsPage.checkErrorWidget("Данных по этому запросу слишком мало"));
        analyticsPage.blockShoot(Blocks.dynamic);
    }
}
