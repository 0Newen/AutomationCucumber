package Steps;

import Base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
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
