import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Find {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mariya\\Desktop\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.avito.ru/");
        Select select = new Select(driver.findElement(By.cssSelector("#category")));
        // select.getOptions().forEach(webElement -> {
        //    System.out.println(webElement.getText());
        //  });

        select.selectByVisibleText("Оргтехника и расходники");
        driver.findElement(By.cssSelector("#search")).click();
        driver.findElement(By.cssSelector("#search")).sendKeys("Принтер");
        driver.findElement(By.className("main-select-2pf7p")).click();
        driver.findElement(By.className("suggest-input-3p8yi")).sendKeys("Владивосток");
        driver.findElement(By.cssSelector("[data-marker='suggest(0)']")).click();
        driver.findElement(By.className("popup-buttons-NqjQ3")).click();
        WebElement webElement = driver.findElement(By.cssSelector("[data-marker='delivery-filter/input']"));

       if (!webElement.isSelected()) {
            driver.findElement(By.cssSelector("[data-marker='delivery-filter/input']")).click();
            driver.findElement(By.cssSelector("[data-marker='search-filters/submit-button']")).click();
        }
        Select select2 = new Select(driver.findElement(By.className("select-select-3CHiM")));
        select2.selectByValue("2");
        int n = 3;
        ArrayList<WebElement> names = (ArrayList) driver.findElements(By.xpath("//h3[contains(@itemprop, 'name')]"));
        ArrayList<WebElement> prices = (ArrayList) driver.findElements(By.xpath("//span/span/meta[contains(@itemprop, 'price')][2]"));
        for (int i = 0; i < n; i++) {
            System.out.println(names.get(i).getText() + "-" + prices.get(i).getText());
        }
    }
}
