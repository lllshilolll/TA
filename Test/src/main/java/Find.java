import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    WebDriverWait wait;

    public Find(WebDriver driver) {
        this.driver = driver;
    }

    public void start() {

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mariya\\Desktop\\chromedriver.exe");

        //driver = new ChromeDriver();
        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Step("open Avito")
    public void avito() {
        driver.get("https://www.avito.ru/");
    }

    @Step("Выбрать в списке 'категория' 'оргтехника и расходники'")
    public void selectCategory() {
        Select select = new Select(driver.findElement(By.cssSelector("#category")));
        select.selectByVisibleText("Оргтехника и расходники");
        makeScreenShot();
    }

    @Step("Ввести 'Принтер'")
    public void findElem() {
        driver.findElement(By.cssSelector("[data-marker='search-form/suggest']")).click();
        driver.findElement(By.cssSelector("[data-marker='search-form/suggest']")).sendKeys("Принтер");
        makeScreenShot();

    }

    @Step("Кликнуть по выпадающему списку региона")
    public void chooseCity() {
        driver.findElement(By.className("main-select-2pf7p")).click();
        driver.findElement(By.className("suggest-input-3p8yi")).click();
    }

    @Step("Ввести город Владивосток")
    public void nameCity() {
        driver.findElement(By.className("suggest-input-3p8yi")).sendKeys("Владивосток");
        wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("Владивосток")));


        driver.findElement(By.cssSelector("[data-marker='suggest(0)']")).click();
    }

    @Step("Показать объявления")
    public void checkBox() {
        driver.findElement(By.className("popup-buttons-NqjQ3")).click();
        makeScreenShot();
    }

    @Step("Проверить, активирован ли чекбокс")
    public void filter() {
        WebElement webElement = driver.findElement(By.cssSelector("[data-marker='delivery-filter/input']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        if (!webElement.isSelected()) {
            driver.findElement(By.xpath("//span[@data-marker='delivery-filter/text']")).click();
            driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
        }
    }

    @Step("Отсортировать по убыванию цены")
    public void price() {
        driver.findElement(By.xpath("//div[contains(@class, 'sort-select')]/select/option[@data-marker='option(2)']")).click();
        makeScreenShot();
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

    public void stop() {
        driver.quit();
    }

}
