import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FundTransfer extends BaseClass{

    public FundTransfer(WebDriver driver) {
        super(driver);
    }

    private By fund = By.xpath("/html/body/div[3]/div/ul/li[10]/a");
    private WebElement fundElement;

    private By payer = By.xpath("//input[@name='payersaccount']");
    private WebElement payerElement;

    private By payee = By.xpath("//input[@name='payeeaccount']");
    private WebElement payeeElement;

    private By amount = By.xpath("//input[@name='ammount']");
    private WebElement amountElement;

    private By desc = By.xpath("//input[@name='desc']");
    private WebElement descElement;

    private By submit = By.xpath("//input[@type='submit']");
    private WebElement submitElement;

    public void fundTransfer(String payeracc, String payeeacc, String ammount, String des){

        fundElement = driver.findElement(fund);
        click(fundElement);

        payerElement = driver.findElement(payer);
        enterText(payerElement, payeracc);

        payeeElement = driver.findElement(payee);
        enterText(payeeElement, payeeacc);

        amountElement = driver.findElement(amount);
        enterText(amountElement, ammount);

        descElement = driver.findElement(desc);
        enterText(descElement, des);

        submitElement = driver.findElement(submit);
        click(submitElement);
    }
}
