import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteAccount extends BaseClass{

    public DeleteAccount(WebDriver driver) {
        super(driver);
    }

    private By deleteAcc = By.xpath("/html/body/div[3]/div/ul/li[7]/a");
    private WebElement deleteElement;

    private By accNo = By.xpath("//input[@name='accountno']");
    private WebElement accNoElement;

    private By submit = By.xpath("//input[@name='AccSubmit']");
    private WebElement submitElement;

    public void deleteAccount(String accNum){
        deleteElement = driver.findElement(deleteAcc);
        click(deleteElement);

        accNoElement = driver.findElement(accNo);
        enterText(accNoElement, accNum);

        submitElement = driver.findElement(submit);
        click(submitElement);

    }

}
