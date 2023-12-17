import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteAccountTest07 extends TestBase{

    private LoginClass login;
    private DeleteAccount delete;

    @Test
    public void deleteAccTest() throws IOException {
        tests = extentrep.createTest("Delete Account", "This test case validates the delete account function");
        login = new LoginClass(driver);
        delete = new DeleteAccount(driver);

        login.SignIn(username, password);
        delete.deleteAccount("130201");

        if(isAlertPresent()){
            Assert.assertTrue(true);
            tests.log(Status.PASS, "Test passed for delete account");
            driver.switchTo().alert().accept();
        }
        else {
            Assert.assertTrue(false);
            tests.log(Status.FAIL, "Test failed for delete account");
        }
        extentrep.flush();
    }
}
