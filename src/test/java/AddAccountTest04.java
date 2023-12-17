import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddAccountTest04 extends TestBase{

    LoginClass login;
    AddAccount acc;
    @Test
    public void AddAccTest() throws IOException {
        tests = extentrep.createTest("Add Account", "This test case validates that an account is added successfully");
        login = new LoginClass(driver);
        login.SignIn(username, password);
        acc = new AddAccount(driver);
        acc.AddAcc(	"69002", "5000");

        String expectedMsg = "Account Generated Successfully!!!";
        String actualMsg = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p")).getText();

        if(actualMsg.equals(expectedMsg)){
            Assert.assertTrue(true);
            tests.log(Status.PASS, "Test passed for adding an account");
            tests.log(Status.PASS, tests.addScreenCaptureFromPath(capture(driver, "Add Account")) + "Test Passed");
        }

        else {
            Assert.assertTrue(false);
            tests.log(Status.FAIL, "Test failed for adding an account");
        }

        acc.Continue();

        extentrep.flush();
    }
}
