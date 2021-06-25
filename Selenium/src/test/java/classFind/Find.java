package classFind;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import stepDef.Price;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Find {
    WebDriver driver;

    public void start() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mariya\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void avito() {
        driver.get("https://www.avito.ru/");
    }

    public void selectCategory(int category) {
        driver.findElement(By.cssSelector("option[value='" + category + "']")).click();
    }

    public void findElem(String name) {
        driver.findElement(By.cssSelector("[data-marker='search-form/suggest']")).click();
        driver.findElement(By.cssSelector("[data-marker='search-form/suggest']")).sendKeys(name);
    }

    public void chooseCity() {
        driver.findElement(By.className("main-select-2pf7p")).click();
        driver.findElement(By.className("suggest-input-3p8yi")).click();
    }

    public void nameCity(String name) {
        driver.findElement(By.className("suggest-input-3p8yi")).sendKeys(name);
    }

    public void checkBox() {
        driver.findElement(By.cssSelector("[data-marker='suggest(0)']")).click();
        driver.findElement(By.className("popup-buttons-NqjQ3")).click();
    }

    public void check(String name) {
        assertTrue(driver.findElement(By.cssSelector("[data-marker='search-form/suggest']")).getAttribute("value").equals(name));
    }

    public void filter() {
        WebElement webElement = driver.findElement(By.cssSelector("[data-marker='delivery-filter/input']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        if (!webElement.isSelected()) {
            driver.findElement(By.xpath("//span[@data-marker='delivery-filter/text']")).click();
            driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
        }
    }

    public void price(Price price) {
        driver.findElement(By.xpath("//div[contains(@class, 'sort-select')]/select/option[@data-marker='option(" + price.getId() + ")']")).click();
    }

    public void listPrinter(int n) {
        ArrayList<WebElement> names = (ArrayList) driver.findElements(By.xpath("//h3[contains(@itemprop, 'name')]"));
        ArrayList<WebElement> prices = (ArrayList) driver.findElements(By.xpath("//span/span/meta[contains(@itemprop, 'price')][2]"));
        for (int i = 0; i < n; i++) {
            System.out.println(names.get(i).getText() + "-" + prices.get(i).getAttribute("content"));
        }
    }

    public void stop() {
        driver.quit();
    }

}