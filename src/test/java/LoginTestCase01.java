import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
public class LoginTestCase01 extends TestBase{

    @DataProvider(name = "testData")
    public static Object[][] userData(){
        return new Object[][]{

                {"mngr542911", "japudAr"},
                {"mngr542991", "japudAr"},

        };
    }

    private LoginClass login;
    private By logout = By.xpath("/html/body/div[3]/div/ul/li[15]/a");
    private WebElement logoutElement;

    @Test(dataProvider = "testData")
    public void LogIn(String user, String pass) throws IOException {
        tests = extentrep.createTest("Login", "This test case validates that the user can login to his account successfully");
        login = new LoginClass(driver);
        login.SignIn(user, pass);

        if (isAlertPresent()) {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);

        } else {
            Assert.assertTrue(true);
            tests.log(Status.PASS, "Test passed for login successfully");
            tests.log(Status.PASS, tests.addScreenCaptureFromPath(capture(driver, "LogIn")) + "Test Passed");
            logoutElement = driver.findElement(logout);
            logoutElement.click();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
        extentrep.flush();
    }
}
