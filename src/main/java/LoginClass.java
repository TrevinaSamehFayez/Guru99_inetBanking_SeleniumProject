import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginClass extends BaseClass{
    public LoginClass(WebDriver driver) {
        super(driver);
    }

    private By username = By.xpath("//input[@type='text']");
    private WebElement usernameElement;

    private By password = By.xpath("//input[@type='password']");
    private WebElement passwordElement;

    private By loginButton = By.xpath("//input[@type='submit']");
    private WebElement loginButtonElement;

    public void SignIn(String user, String pass){
        usernameElement = driver.findElement(username);
        passwordElement = driver.findElement(password);

        enterText(usernameElement, user);
        enterText(passwordElement, pass);

        loginButtonElement = driver.findElement(loginButton);
        click(loginButtonElement);
    }

}
