package steps;

import base.baseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.openqa.selenium.chrome.ChromeDriver;

public class hookSteps extends baseUtil {

    private baseUtil base;

    public hookSteps(baseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest(Scenario scenario){
        System.out.println("Opening the browser: Chrome");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\57316\\IdeaProjects\\opensourcecms\\src\\Drivers\\chromedriver.exe");
        base.Driver=new ChromeDriver();
    }

    @After
    public void tearDownTest(Scenario scenario){
        System.out.println("Closing the browser: Chrome");
        base.Driver.close();
    }

}
