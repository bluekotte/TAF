import data.DataForDivInt;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTestDivInt extends BaseTest{
    // ToDo: Форматирование текста в классе Code -> Reformat Code
    // ToDo: Название тестовых методов - переделать согласно https://dzone.com/articles/7-popular-unit-test-naming
    @Test
    public void testDivInt() {
        Assert.assertEquals(calculator.divInt(4, 2), 2, "неверно...");
    }

    // Todo: Между методами должна быть пустая строка
    @Test (enabled = false)
    public void testDivInt1() {
        Assert.assertEquals(calculator.divInt(4, 2), 2, "неверно...");
    }
    @Test (description = "Тест с описанием")
    public void testDivInt2() {
        Assert.assertEquals(calculator.divInt(4, 2), 2, "неверно...");
    }
    @Test (testName = "Test with name")
    public void testDivInt3() {
        Assert.assertEquals(calculator.divInt(4, 2), 2, "неверно...");
    }
    @Test (timeOut = 1000)
    public void WaitingTimeTest() throws InterruptedException {
        Thread.sleep(1000);
    }
    @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void invocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.divInt(4, 2), 2, "неверно...");
    }

    @Test (dataProvider = "DataForDivInt", dataProviderClass = DataForDivInt.class)
    public void testDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.divInt(a, b), expectedResult, "неверно");
    }

    @Test (expectedExceptions = NullPointerException.class)
    public void testExeptions() {
        List list = null;
        int size = list.size();
    }

    // ToDo: Отсутствуют тесты деления на 0
    // ToDo: Отсутствуют тесты с параметрами передаваемыми из TestNG.xml
    // ToDo: Отсутствуют зависимые тесты
    // ToDo: Отсутствуют приоритизированные тесты
}
