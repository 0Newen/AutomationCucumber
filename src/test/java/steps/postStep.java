package steps;
import base.baseUtil;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.loginPage;
import pages.postPage;

import java.util.List;
import java.util.Map;

public class postStep extends baseUtil {

    private baseUtil base;
    postPage postPage=new postPage(base.Driver);

    public postStep(baseUtil base) {
        this.base = base;
    }

    @And("I click in Post menu")
    public void iClickInPostMenu() {
        postPage.actMenuPost();
    }


    @And("I click in newPost")
    public void iClickInNewPost() {
        postPage.actNewPost();
    }

    @DataTableType
    public Post EntryTransformer(Map<String, String> entry) {
        return new Post(
                entry.get("title"),
                entry.get("body"));
    }

    @Given("a new title and body")
    public void aNewTitleAndBody(List<Post> posts) {
        for (Post post:posts) {
            postPage.actTitlePostAndBody(post.getTitle(),post.getBody());
        }
    }

    @And("I click on Publish")
    public void iClickOnPublish() {
        postPage.actBtnSaveDraft();
        postPage.actBtnPublish();
    }

    @Then("I validate the labelPublished")
    public void iValidateTheLabelPublished() {
        postPage.actNoticePublicCheck();
    }

    @And("I check the Post on table")
    public void iCheckThePostOnTable() {
        System.out.println("Just Validate in the Main Menu.");
    }

    public class Post{
        String title;
        String body;

        public Post(String title, String body) {
            this.title = title;
            this.body = body;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        @Override
        public String toString() {
            return "post{" +
                    "title='" + title + '\'' +
                    ", body='" + body + '\'' +
                    '}';
        }
    }
}
