import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class AddCustomerTest02 extends TestBase {

    private LoginClass login;
    private AddCustomer customer;
    @Test
    public void AddCustomerTest() throws IOException, InterruptedException {
        tests = extentrep.createTest("Add Customer", "This test case validates adding a customer successfully");
        login = new LoginClass(driver);
        customer = new AddCustomer(driver);
        login.SignIn(username, password);
        customer.clickNewCustomer();
        customer.enterName("Vena Sameh");
        customer.gender();
        customer.addBirthDate("10","12","1996");
        Thread.sleep(10000);
        customer.enterAddress("Egypt");
        customer.enterCity("Cairo");
        customer.enterState("Cairo");
        customer.enterPIN("122345");
        customer.enterMobile("011214456");
        customer.enterEmail("Deemo1@gmail.com");
        customer.enterPassword("ussr_2neew");
        customer.submitForm();

        if (isAlertPresent()) {
            driver.switchTo().alert().accept();
            Assert.assertTrue(false);
        } else {

            String expectedMsg = "Customer Registered Successfully!!!";
            String actualMsg = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p")).getText();

            if (actualMsg.equals(expectedMsg)) {
                Assert.assertTrue(true);
                tests.log(Status.PASS, "Test passed for Creating a new customer");
                tests.log(Status.PASS, tests.addScreenCaptureFromPath(capture(driver, "AddCustomer")) + "Test Passed");
            }
        }
    }
}

