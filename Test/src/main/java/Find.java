import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Find {
    WebDriver driver;

  /*  public Find(WebDriver driver) {
        this.driver = driver;
    }*/

    public void start() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mariya\\Desktop\\chromedriver.exe");

        driver = new ChromeDriver();
        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step("open Avito")
    public void avito() {
        driver.get("https://www.avito.ru/");
    }

    @Step("Выбрать в списке 'категория' 'оргтехника и расходники'")
    public void selectCategory() {
        Select select = new Select(driver.findElement(By.cssSelector("#category")));
        // select.getOptions().forEach(webElement -> {
        //    System.out.println(webElement.getText());
        //  });

        select.selectByVisibleText("Оргтехника и расходники");
    }

    @Step("Ввести 'Принтер'")
    public void findElem() {
        driver.findElement(By.cssSelector("#search")).click();
        driver.findElement(By.cssSelector("#search")).sendKeys("Принтер");
    }

    @Step("Ввести город Владивосток")
    public void chooseCity() {
        driver.findElement(By.className("main-select-2pf7p")).click();
        driver.findElement(By.className("suggest-input-3p8yi")).sendKeys("Владивосток");
    }

    @Step("Показать результаты")
    public void checkBox() {

        driver.findElement(By.cssSelector("[data-marker='suggest(0)']")).click();
        driver.findElement(By.className("popup-buttons-NqjQ3")).click();
    }

    //    WebElement webElement = driver.findElement(By.cssSelector("[data-marker='delivery-filter/input']"));

    /*if (!webElement.isSelected()) {
         driver.findElement(By.xpath("//span[@data-marker='delivery-filter/text']")).click();
         driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
     }*/
    @Step("Отсортировать по убыванию цены")
    public void price() {
        driver.findElement(By.xpath("//div[contains(@class, 'sort-select')]/select/option[@data-marker='option(2)']")).click();
    }

    @Step("Вывести три самых дорогих принтера с ценой")
    public void listPrinter() {
        int n = 3;
        ArrayList<WebElement> names = (ArrayList) driver.findElements(By.xpath("//h3[contains(@itemprop, 'name')]"));
        ArrayList<WebElement> prices = (ArrayList) driver.findElements(By.xpath("//span/span/meta[contains(@itemprop, 'price')][2]"));
        for (int i = 0; i < n; i++) {
            System.out.println(names.get(i).getText() + "-" + prices.get(i).getAttribute("content"));
        }
    }

    @Attachment
    @Step("Make screen shot of results page")
    public byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Attachment
    @Step("Make screen shot of element on the page")
    public byte[] makeAshotScreenShot() {
        // Find the element to take a screenshot
        WebElement element = driver.findElement(By.cssSelector("header.serp-header"));

        // Along with driver pass element also in takeScreenshot() method.
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, element);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            ImageIO.write(screenshot.getImage(), "PNG", buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }

    public void stop() {
        driver.quit();
    }

}
