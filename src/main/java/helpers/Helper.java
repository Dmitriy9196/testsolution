package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public WebDriver driver;

    private static String reportFolderName;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    private static String getDate() {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss-dd_MM");
        return format.format(dateNow);
    }


    public void takeScreenshot(String place) {
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = place + "_" + getDate() + ".png";
        String filePath = "reports\\" + reportFolderName + "\\" + fileName;
        try {
            FileUtils.copyFile(screen, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeReportFolder() {

        reportFolderName = "Report_" + getDate();
        File folder = new File("reports\\" + reportFolderName);
        if(!folder.exists()){ folder.mkdir(); }

    }

    public void scrollToElement(HtmlElement block) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", block);
    }

    public void scrollToTop() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scroll(top)", "");
    }
}
