import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
public class AddCustomer extends BaseClass{
    public AddCustomer(WebDriver driver) {
        super(driver);
    }

    private By newCustomer = By.xpath("/html/body/div[3]/div/ul/li[2]/a");
    private WebElement newCustomerElement;

    private By name = By.xpath("//input[@name='name']");
    private WebElement nameElement;

    private By female = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]");
    private WebElement femaleElement;

    private By datebox = By.xpath("//*[@id=\"dob\"]");
    private WebElement dateboxElement;
    private By address = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea");
    private WebElement addressElement;

    private By city = By.xpath("//input[@name='city']");
    private WebElement cityElement;

    private By state = By.xpath("//input[@name='state']");
    private WebElement stateElement;

    private By pin = By.xpath("//input[@name='pinno']");
    private WebElement pinElement;

    private By mobile = By.xpath("//input[@name='telephoneno']");
    private WebElement mobileElement;

    private By email = By.xpath("//input[@name='emailid']");
    private WebElement emailElement;

    private By password = By.xpath("//input[@name='password']");
    private WebElement passwordElement;

    private By submit = By.xpath("//input[@type='submit']");
    private WebElement submitElement;
    public void clickNewCustomer(){
        newCustomerElement = driver.findElement(newCustomer);
        click(newCustomerElement);
    }
    public void enterName(String usrname){
        nameElement = driver.findElement(name);
        enterText(nameElement, usrname);
    }

    public void gender(){
        femaleElement = driver.findElement(female);
        click(femaleElement);
    }

    public void addBirthDate(String mm,String dd,String yy) {
        dateboxElement = driver.findElement(datebox);
        dateboxElement.sendKeys(mm);
        dateboxElement.sendKeys(dd);
        dateboxElement.sendKeys(yy);
   }
    public void enterAddress(String addr){
        addressElement = driver.findElement(address);
        enterText(addressElement, addr);
    }

    public void enterCity(String c){
        cityElement = driver.findElement(city);
        enterText(cityElement, c);
    }

    public void enterState(String s){
        stateElement = driver.findElement(state);
        enterText(stateElement, s);
    }

    public void enterPIN(String p){
        pinElement = driver.findElement(pin);
        enterText(pinElement, p);
    }

    public void enterMobile(String phone){
        mobileElement = driver.findElement(mobile);
        enterText(mobileElement, phone);
    }

    public void enterEmail(String userEmail){
        emailElement = driver.findElement(email);
        enterText(emailElement, userEmail);
    }

    public void enterPassword(String usrpass){
        passwordElement = driver.findElement(password);
        enterText(passwordElement, usrpass);
    }

    public void submitForm(){
        submitElement = driver.findElement(submit);
        click(submitElement);
    }

}
