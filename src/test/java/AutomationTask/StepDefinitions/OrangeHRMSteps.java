package AutomationTask.StepDefinitions;


import AutomationTask.PageObjects.AdminPage;
import AutomationTask.PageObjects.LoginPage;
import AutomationTask.Utilities.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class OrangeHRMSteps {


    private WebDriver driver;
    private LoginPage loginPage;
    private AdminPage adminPage;
    private int initialRecordCount;

    @Given("I navigate to the OrangeHRM login page")
    public void i_navigate_to_the_orange_hrm_login_page() {
        driver = WebDriverManager.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @When("I click on the Admin tab")
    public void i_click_on_the_admin_tab() {
        adminPage = new AdminPage(driver);
        adminPage.clickAdminTab();
    }

    @When("I get the number of records")
    public void i_get_the_number_of_records() {
        initialRecordCount = adminPage.getRecordCount();
    }

    @When("I add a new user with employee name {string}, username {string}, password {string}, user role {string}, and status {string}")
    public void i_add_a_new_user_with_employee_name_username_password_user_role_and_status(
            String employeeName, String username, String password, String userRole, String status) {
        adminPage.clickAddButton();
        adminPage.fillUserDetails(employeeName, username, password, userRole, status);
        adminPage.clickSaveButton();
    }

    @Then("the number of records should increase by {int}")
    public void the_number_of_records_should_increase_by(int increase) {
        int newRecordCount = adminPage.getRecordCount();
        Assert.assertEquals(newRecordCount, initialRecordCount + increase, "The number of records did not increase by " + increase);
    }
    @When("I search for the user with username {string}")
    public void i_search_for_the_user_with_username(String username) {
        adminPage.searchUser(username);
    }

    @When("I delete the user")
    public void i_delete_the_user() {
        adminPage.deleteUser();
    }

    @Then("the number of records should decrease by {int}")
    public void the_number_of_records_should_decrease_by(int decrease) {
        int newRecordCount = adminPage.getRecordCount();
        Assert.assertEquals(newRecordCount, initialRecordCount , "The number of records did not decrease by " + decrease);
    }

    @Then("the user with username {string} should exist")
    public void the_user_with_username_should_exist(String username) {
        int recordCount = adminPage.getRecordCount();
        Assert.assertTrue(recordCount > 0, "User with username " + username + " was not found.");
    }
}
