import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddAccount extends BaseClass{
    public AddAccount(WebDriver driver) {
        super(driver);
    }

    private By account = By.xpath("/html/body/div[3]/div/ul/li[5]/a");
    private WebElement accountElement;

    private By id = By.xpath("//input[@name='cusid']");
    private WebElement idElement;

    private By dropbox = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td[2]/select");
    private WebElement dropboxElement;

    private By option = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td[2]/select/option[2]");
    private WebElement optionElement;

    private By deposit = By.xpath("//input[@name='inideposit']");
    private WebElement depositElement;

    private By submit = By.xpath("//input[@type='submit']");
    private WebElement submitElement;

    private By cont = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[11]/td/a");
    private WebElement continueElement;

    public void AddAcc(String cID, String dep){

        accountElement = driver.findElement(account);
        click(accountElement);

        idElement = driver.findElement(id);
        enterText(idElement, cID);

        dropboxElement = driver.findElement(dropbox);
        click(dropboxElement);

        optionElement = driver.findElement(option);
        click(optionElement);

        depositElement = driver.findElement(deposit);
        enterText(depositElement, dep);

        submitElement = driver.findElement(submit);
        click(submitElement);
    }
    public void Continue(){
        continueElement = driver.findElement(cont);
        click(continueElement);
    }
}
