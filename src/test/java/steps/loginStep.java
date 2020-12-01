package steps;

import base.baseUtil;
import pages.loginPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class loginStep extends baseUtil {

    private baseUtil base;
    loginPage loginPage = new loginPage(base.Driver);

    public loginStep(baseUtil base) {
        this.base = base;
    }

    @And("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        base.Driver.navigate().to("https://s1.demo.opensourcecms.com/wordpress/wp-login.php?loggedout=true");
        WebDriverWait wait = new WebDriverWait(base.Driver, 2);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginform")));
    }

    @And("I click login button")
    public void iClickLoginButton() {
        loginPage.clickSubmit();
    }

    @Then("I should see the dashboard page")
    public void iShouldSeeTheDashboardPage() {
        loginPage.checkEntry();
    }

    @DataTableType
    public User EntryTransformer(Map<String, String> entry) {
        return new User(
                entry.get("username"),
                entry.get("password"));
    }

    @Given("a list of users in a table")
    public void aListOfUsersInATable(List<User> users) {
        for (User user : users) {
            loginPage.Login(user.getUsername(), user.getPassword());
        }
    }

    @Then("I check the error message Appears")
    public void iCheckTheErrorMessageAppears() {
        loginPage.checkWrongCredentials();
    }

    @And("I click lost your password?")
    public void iClickLstYourPassword() {
        loginPage.recoveryPassword();
    }

    @Then("I check the button for recovery")
    public void iCheckTheButtonForRecovery() {
        loginPage.chechRecoveryPassword();
    }

    public class User {

        public String username;
        public String password;


        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
