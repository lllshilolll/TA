import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Find {
    WebDriver driver;

    public Find(WebDriver driver) {
        this.driver = driver;
    }

    public void start() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mariya\\Desktop\\chromedriver.exe");
        //driver = new ChromeDriver();
        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void avito() {
        driver.get("https://www.avito.ru/");
    }

    public void selectCategory() {
        Select select = new Select(driver.findElement(By.cssSelector("#category")));
        // select.getOptions().forEach(webElement -> {
        //    System.out.println(webElement.getText());
        //  });

        select.selectByVisibleText("Оргтехника и расходники");
    }

    public void findElem() {
        driver.findElement(By.cssSelector("#search")).click();
        driver.findElement(By.cssSelector("#search")).sendKeys("Принтер");
    }

    public void chooseCity() {
        driver.findElement(By.className("main-select-2pf7p")).click();
        driver.findElement(By.className("suggest-input-3p8yi")).sendKeys("Владивосток");
    }

    public void checkBox() {

        driver.findElement(By.cssSelector("[data-marker='suggest(0)']")).click();
        driver.findElement(By.className("popup-buttons-NqjQ3")).click();
    }

    //    WebElement webElement = driver.findElement(By.cssSelector("[data-marker='delivery-filter/input']"));

    /*if (!webElement.isSelected()) {
         driver.findElement(By.xpath("//span[@data-marker='delivery-filter/text']")).click();
         driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
     }*/
    public void price() {
        driver.findElement(By.xpath("//div[contains(@class, 'sort-select')]/select/option[@data-marker='option(2)']")).click();
    }

    public void listPrinter() {
        int n = 3;
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
