import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestFind {
    Find steps = new Find();

    @Before
    public void setUp() throws Exception {
        steps.start();
    }

    @Test
    public void searchTest() throws Exception {
        steps.avito();
        steps.selectCategory();
        steps.findElem();
        steps.chooseCity();
        steps.checkBox();
        steps.price();
        steps.listPrinter();
    }

    @After
    public void stop() {
        steps.stop();
    }


}
