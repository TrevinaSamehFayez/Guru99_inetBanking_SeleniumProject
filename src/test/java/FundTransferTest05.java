import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FundTransferTest05 extends TestBase{

    private LoginClass login;
    private FundTransfer trans;

    @Test
    public void FundTransferTest() throws IOException {
        tests = extentrep.createTest("Fund Transfer", "This test case validates the Fund Transfer function");
        login = new LoginClass(driver);
        trans = new FundTransfer(driver);
        login.SignIn(username, password);
        trans.fundTransfer("130201", "130196", "1000", "Fund Transfer");

        String expectedMsg = "Fund Transfer Details";
        String actualMsg = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/p")).getText();

        if(actualMsg.equals(expectedMsg)){
            Assert.assertTrue(true);
            tests.log(Status.PASS, "Test passed for Fund Transfer");
            tests.log(Status.PASS, tests.addScreenCaptureFromPath(capture(driver, "Fund Transfer")) + "Test Passed");
        }

        else {
            tests.log(Status.FAIL, "Test failed for Fund Transfer");
            Assert.assertTrue(false);
        }
        extentrep.flush();
    }
}


//Fund Transfer Details
