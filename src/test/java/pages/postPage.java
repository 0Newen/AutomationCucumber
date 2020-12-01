package pages;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class postPage {

    public postPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/div[2]/ul/li[3]/a/div[3]")
    public WebElement frame;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/div[2]/ul/li[3]/ul/li[3]/a")
    public WebElement newPost;

    @FindBy(how = How.XPATH, using = "//*[@id=\"editor\"]/div/div/div/div[5]/div/div/div/div/button/svg/path")
    public WebElement closePopUp;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[2]/div[1]/div[5]/div[1]/div/div/div/div[2]/div[3]/div/div[1]/div/div/div[1]/div/div/div/textarea")
    public WebElement titlePost;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[2]/div[1]/div[5]/div[1]/div/div/div/div[2]/div[3]/div/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div/p")
    public WebElement bodyPost;

    @FindBy(how = How.XPATH, using = "//*[@id=\"editor\"]/div/div/div/div[1]/div[2]/button[1]")
    public WebElement btnSaveDraft;

    @FindBy(how = How.XPATH, using = "//*[@id=\"editor\"]/div/div/div/div[1]/div[2]/button[2]")
    public WebElement btnPublish;

    @FindBy(how = How.CLASS_NAME, using = "components-notice__content")
    public WebElement noticePublish;






    //TODO:Main actuators methods to post steps

    public void actMenuPost() {
        frame.click();
    }

    public void actNewPost() {
        newPost.click();
    }

    public void actTitlePostAndBody(String title, String body) {
        titlePost.sendKeys(title);
        bodyPost.click();
        bodyPost.sendKeys(body);
    }

    public void actBtnSaveDraft() {
        btnSaveDraft.click();
    }

    public void actBtnPublish() {
        btnPublish.click();
    }

    public void actNoticePublicCheck(){
        Assert.assertTrue(noticePublish.isDisplayed());
    }
}


