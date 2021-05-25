import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        Find driver = new Find(new ChromeDriver());
        driver.start();
        driver.avito();
        driver.selectCategory();
        driver.findElem();
        driver.chooseCity();
        driver.checkBox();
        driver.price();
        driver.listPrinter();
        driver.stop();
    }
}
