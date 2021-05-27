import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFind {
    Find steps;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mariya\\Desktop\\chromedriver.exe");
        steps = new Find(new ChromeDriver());
        steps.start();
    }

    @Test
    public void avitoTest() {
        steps.avito();
        steps.selectCategory();
        steps.findElem();
        steps.chooseCity();
        steps.checkBox();
        steps.filter();
        steps.price();
        steps.listPrinter();
        steps.stop();
    }
}