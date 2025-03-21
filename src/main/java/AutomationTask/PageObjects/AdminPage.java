package AutomationTask.PageObjects;


import AutomationTask.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPage extends AbstractComponent {

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminTab;

    @FindBy(xpath = "//div[@class='oxd-table-card']")
    private List<WebElement> resultTableRows;

    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement addButton;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameField;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement usernameField;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement passwordField;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement saveButton;

    @FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div/input")
    private WebElement searchUsernameField;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    private WebElement searchButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']/parent::button")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[text()=' Yes, Delete ']")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//label[text()='User Role']/following::div[@class='oxd-select-text-input'][1]")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "//label[text()='Status']/following::div[@class='oxd-select-text-input'][1]")
    private WebElement statusDropdown;

    public AdminPage(WebDriver driver) {
        super(driver); // Call the BasePage constructor
    }

    public void clickAdminTab() {
        waitForElementToBeClickable(adminTab);
        adminTab.click();
    }

    public int getRecordCount() {
        waitForAllElementsToBeVisible(resultTableRows);
        return resultTableRows.size();
    }

    public void clickAddButton() {
        waitForElementToBeClickable(addButton);
        addButton.click();
    }

    public void fillUserDetails(String employeeName, String username, String password, String userRole, String status) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        waitForElementToBeVisible(employeeNameField);
        employeeNameField.sendKeys(employeeName);

        By dropdownOptionLocator = By.xpath("//div[@role='listbox']//div[contains(@class, 'oxd-autocomplete-option') and contains(., '" + employeeName + "')]");
        waitForElementToBePresent(dropdownOptionLocator);

        WebElement employeeNameOption = driver.findElement(dropdownOptionLocator);
        waitForElementToBeClickable(employeeNameOption);
        employeeNameOption.click();

        waitForElementToBeVisible(usernameField);
        usernameField.sendKeys(username);

        waitForElementToBeClickable(userRoleDropdown);
        userRoleDropdown.click();
        WebElement userRoleOption = driver.findElement(By.xpath(String.format("//div[@role='option']/span[text()='%s']", userRole)));
        waitForElementToBeClickable(userRoleOption);
        userRoleOption.click();

        waitForElementToBeClickable(statusDropdown);
        statusDropdown.click();
        WebElement statusOption = driver.findElement(By.xpath(String.format("//div[@role='option']/span[text()='%s']", status)));
        waitForElementToBeClickable(statusOption);
        statusOption.click();

        waitForElementToBeVisible(passwordField);
        passwordField.sendKeys(password);

        waitForElementToBeVisible(confirmPasswordField);
        confirmPasswordField.sendKeys(password);
    }
    public void clickSaveButton() {
        waitForElementToBeClickable(saveButton);
        saveButton.click();
    }

    public void searchUser(String username) {
        waitForElementToBeVisible(searchUsernameField);
        searchUsernameField.clear();
        searchUsernameField.sendKeys(username);

        waitForElementToBeClickable(searchButton);
        searchButton.click();

        waitForAllElementsToBeVisible(resultTableRows);
    }

    public void deleteUser() {
        waitForElementToBeClickable(deleteButton);
        deleteButton.click();

        waitForElementToBeClickable(confirmDeleteButton);
        confirmDeleteButton.click();

        refreshPage();
        waitForAllElementsToBeVisible(resultTableRows);
    }
}
