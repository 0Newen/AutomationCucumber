package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
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

}
