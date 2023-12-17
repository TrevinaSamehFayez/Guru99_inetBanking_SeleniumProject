import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Withdrawal extends BaseClass{
    public Withdrawal(WebDriver driver) {
        super(driver);
    }

    private By withdrawal = By.xpath("/html/body/div[3]/div/ul/li[9]/a");
    private WebElement withdrawElement;

    private By account = By.xpath("//input[@name='accountno']");
    private WebElement accountElement;

    private By amount = By.xpath("//input[@name='ammount']");
    private WebElement amountElement;

    private By desc = By.xpath("//input[@name='desc']");
    private WebElement descElement;

    private By submit = By.xpath("//input[@name='AccSubmit']");
    private WebElement submitElement;

    public void withdraw(String acc, String ammount, String des){
        withdrawElement = driver.findElement(withdrawal);
        click(withdrawElement);

        accountElement = driver.findElement(account);
        enterText(accountElement, acc);

        amountElement = driver.findElement(amount);
        enterText(amountElement, ammount);

        descElement = driver.findElement(desc);
        enterText(descElement, des);

        submitElement = driver.findElement(submit);
        click(submitElement);
    }
}
