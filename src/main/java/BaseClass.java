import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {

    protected WebDriver driver;

    public BaseClass(WebDriver driver){
        this.driver = driver;
    }

    public void enterText(WebElement element, String text){
        element.sendKeys(text);
    }

    public void click(WebElement button){
        button.click();
    }
}
