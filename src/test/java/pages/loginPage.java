package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import sun.security.util.Password;

public class loginPage {

    public loginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.NAME,using = "log")
    public WebElement tilUsername;

    @FindBy(how = How.NAME,using = "pwd")
    public WebElement tilPassword;

    @FindBy(how = How.NAME,using = "wp-submit")
    public WebElement btnLogin;

    @FindBy(how = How.XPATH,using = "//*[@id=\"wpbody-content\"]/div[5]/h1")
    public WebElement txtDashBoard;

    @FindBy(how = How.ID,using = "login_error")
    public WebElement txtError;

    @FindBy(how = How.XPATH,using = "//*[@id=\"nav\"]")
    public WebElement btnLostUPass;

    @FindBy(how = How.ID,using = "wp-submit")
    public WebElement btnRecoveryPass;




    public void Login(String username, String password){
        tilUsername.sendKeys(username);
        tilPassword.sendKeys(password);
    }

    public void clickSubmit(){
        btnLogin.submit();
    }

    public void checkEntry(){
        Assert.assertTrue(txtDashBoard.isDisplayed());
    }

    public void checkWrongCredentials(){
        Assert.assertTrue(txtError.isDisplayed());
    }

    public void recoveryPassword(){
        btnLostUPass.click();
    }

    public void chechRecoveryPassword(){
        Assert.assertTrue(btnRecoveryPass.isDisplayed());
    }

}
