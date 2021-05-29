package stepDef;

import classFind.Find;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.After;
import org.junit.Before;


public class TestFind {
    Find steps = new Find();

    @ParameterType(".*")
    public Categories categories(String category) {
        return Categories.valueOf(category);
    }

    @ParameterType(".*")
    public Price price(String price) {
        return Price.valueOf(price);
    }

    /**@Before
    public void setUp() {
        steps.start();
    }*/

    @Пусть("открыт ресурс авито")
    public void avito() {
        steps.start();
        steps.avito();
    }

    @И("в выпадающем списке категорий выбрана {categories}")
    public void selectCategory(Categories category) {
        steps.selectCategory(category.getId());
    }

    @И("в поле поиска введено значение {word}")
    public void findElem(String name) {
        steps.findElem(name);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void chooseCity() {
        steps.chooseCity();
    }

    @Тогда("в поле регион введено значение {word}")
    public void nameCity(String name) {
        steps.nameCity(name);
    }

    @И("нажата кнопка показать объявления")
    public void checkBox() {
        steps.checkBox();
    }

    @Тогда("открыласть страница результаты по запросу {word}")
    public void check(String name) {
        steps.check(name);
    }

    @И("активирован чекбокс только с доставкой")
    public void filter() {
        steps.filter();
    }

    @И("в выпадающем списке сотировка выбрано значение {price}")
    public void price(Price price) {
        steps.price(price);
    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public void listPrinter(int n) {
        steps.listPrinter(n);
    }

    @After
    public void setDown() {
        steps.stop();
    }
}