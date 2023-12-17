import Utility.readconfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
public class TestBase {
    readconfig read = new readconfig();

    public static ExtentTest tests;
    public static ExtentReports extentrep = new ExtentReports();
    protected WebDriver driver;
    protected String username = read.getUsername();
    protected String password = read.getPassword();

    @BeforeTest
    public void Setup() {
        driver = new FirefoxDriver();
        driver.navigate().to(read.getAppUrl());
        ExtentSparkReporter Spark = new ExtentSparkReporter("target/spark.html");
        extentrep.attachReporter(Spark);
    }

    public static String capture(WebDriver driver, String tname) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File target = new File("src/../Images/" + tname + ".png");

        String flpath = target.getAbsolutePath();
        FileUtils.copyFile(source, target);
        return flpath;
    }

    public boolean isAlertPresent() {

        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }

    }

    public class DateTime {

        public static String getCurrentTime(String timeFormat) {
            return new SimpleDateFormat(timeFormat).format(Calendar.getInstance().getTime());
        }

        public static String convertDateToNewFormat(String dateStr, String oldFormat, String newFormat) throws ParseException {
            DateFormat sdf = new SimpleDateFormat(oldFormat, Locale.US);
            Date dateParse;
            String newDate = null;
            try {
                dateParse = sdf.parse(dateStr);
                newDate = (new SimpleDateFormat(newFormat)).format(dateParse);
                System.out.println(newDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return newDate;
        }
    }
}
