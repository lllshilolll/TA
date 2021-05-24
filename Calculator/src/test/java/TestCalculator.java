import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculator {
    public TestCalculator() {
    }

    @DataProvider(name = "Positive")
    public static Object[][] testDataPos() {
        return new Object[][]{{5, '+', 9, 14}, {8, '-', 10, -2}, {8, '*', 10, 80}, {9, '/', 3, 3}};
    }

    @Test(dataProvider = "Positive")
    public void TestCalculatorPos(int a, char z, int b, int result) {
        Assert.assertEquals(result, Calculator.calculator(a, z, b), "Не равны");
    }

    @DataProvider(name = "Negative")
    public static Object[][] testDataNeg() {
        return new Object[][]{{5, '+', 9, 20}, {8, '-', 10, 2}, {8, '*', 10, 18}, {9, '/', 0, 3}};
    }

    @Test(dataProvider = "Negative")
    public void TestCalculatorNeg(int a, char z, int b, int result) {
        Assert.assertNotEquals(result, Calculator.calculator(a, z, b), "Равны");
    }

    @DataProvider(name = "Boundary")
    public static Object[][] testDataBon() {
        return new Object[][]{{2147483647, '+', 1, -2147483648}, {-2147483648, '-', 1, 2147483647}, {10, '*', 0, 0}, {9, '/', 0, 0}};
    }

    @Test(dataProvider = "Boundary")
    public void TestCalculatorBon(int a, char z, int b, int result) {
        Assert.assertEquals(result, Calculator.calculator(a, z, b), "Не равны");
    }
}
