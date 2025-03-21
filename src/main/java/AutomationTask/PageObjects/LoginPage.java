package AutomationTask.PageObjects;
import AutomationTask.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractComponent {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']") // Login button
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        waitForElementToBeVisible(usernameField);
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForElementToBeVisible(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        waitForElementToBeClickable(loginButton);
        loginButton.click();
    }

    }
