import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class WithdrawalTest06 extends TestBase{

    private LoginClass login;
    private Withdrawal withd;

    @Test
    public void WithdrawalTest() throws IOException {
        tests = extentrep.createTest("Withdrawal", "This test case validates the Withdrawal function");
        login = new LoginClass(driver);
        withd = new Withdrawal(driver);

        login.SignIn(username, password);
        withd.withdraw("130201", "1000", "withdrawal amount");

        String expectedMsg = "Transaction details of Withdrawal for Account 130201";
        String actualMsg = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p")).getText();

        if(actualMsg.equals(expectedMsg)){
            Assert.assertTrue(true);
            tests.log(Status.PASS, "Test passed for Withdrawal");
            tests.log(Status.PASS, tests.addScreenCaptureFromPath(capture(driver, "Withdrawal")) + "Test Passed");
        }
        else {
            tests.log(Status.FAIL, "Test failed for Withdrawal");
            Assert.assertTrue(false);
        }

        extentrep.flush();
    }
}
