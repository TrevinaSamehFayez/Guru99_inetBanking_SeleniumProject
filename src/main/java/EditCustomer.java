import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditCustomer extends BaseClass{

    public EditCustomer(WebDriver driver) {
        super(driver);
    }
    private By edit = By.xpath("/html/body/div[3]/div/ul/li[3]/a");
    private WebElement editElement;
    private By id = By.xpath("//input[@type='text']");
    private WebElement idElement;

    private By submit = By.xpath("//input[@type='submit']");
    private WebElement submitElement;

    private By email = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input");
    private WebElement emailElement;

    private By submit2 = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input[1]");
    private WebElement submit2Element;
    public void EditCustomer(String custID, String newEmail){
        editElement = driver.findElement(edit);
        click(editElement);

        idElement = driver.findElement(id);
        enterText(idElement, custID);

        submitElement = driver.findElement(submit);
        click(submitElement);

        emailElement = driver.findElement(email);
        emailElement.clear();
        emailElement.sendKeys(newEmail);

    }

    public void submitForm(){
        submit2Element = driver.findElement(submit2);
        click(submit2Element);
    }
}
