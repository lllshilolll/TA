import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        features = "src/test/java/resources/",
        glue = "stepDef",
        tags = "@all")
public class RunTest {
    public void run() {
    }
}

