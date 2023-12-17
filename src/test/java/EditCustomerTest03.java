import com.aventstack.extentreports.Status;
import org.apache.commons.math3.analysis.function.Add;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditCustomerTest03 extends TestBase{

    LoginClass login ;
    EditCustomer cust;

    @Test
    public void EditTest() throws IOException {
        tests = extentrep.createTest("Edit Customer", "This test case validates that customer can edit  his data successfully");
        login = new LoginClass(driver);
        cust = new EditCustomer(driver);

        login.SignIn(username, password);
        cust.EditCustomer("69002", "demo144@gmail.com");

        if(driver.getTitle().equals("Guru99 Bank Edit Customer Entry Page")){
            tests.log(Status.PASS, tests.addScreenCaptureFromPath(capture(driver, "Edit Customer")) + "Test Passed");
        }
        cust.submitForm();
        if(isAlertPresent()){
            driver.switchTo().alert().accept();
            Assert.assertTrue(true);
            tests.log(Status.PASS, "Test passed for Edit Customer");
        }

        else{
            tests.log(Status.FAIL, "Test failed for Edit Customer");
            Assert.assertTrue(false);
        }

        extentrep.flush();
    }
}
