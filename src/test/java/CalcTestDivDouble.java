import data.DataForDivDouble;
import data.DataForDivInt;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTestDivDouble extends BaseTest{
    @Test
    public void testDivDouble() {
        Assert.assertEquals(calculator.divDouble(4.2, 2.1), 2, "неверно...");
    }
    @Test (enabled = false)
    public void testDivDouble1() {
        Assert.assertEquals(calculator.divDouble(4.2, 2.1), 2, "неверно...");
    }
    @Test (description = "Тест с описанием")
    public void testDivDouble2() {
        Assert.assertEquals(calculator.divDouble(4.2, 2.1), 2, "неверно...");
    }
    @Test (testName = "Test with name")
    public void testDivDouble3() {
        Assert.assertEquals(calculator.divDouble(4.2, 2.1), 2, "неверно...");
    }
    @Test (timeOut = 1000)
    public void WaitingTimeTest() throws InterruptedException {
        Thread.sleep(1000);
    }
    @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void invocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.divDouble(4.2, 2.1), 2, "неверно...");
    }

    @Test (dataProvider = "dataForDivDouble", dataProviderClass = DataForDivDouble.class, threadPoolSize = 3)
    public void testDataProvider(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.divDouble(a, b), expectedResult, "неверно");
    }

    @Test (expectedExceptions = NullPointerException.class)
    public void testExeptions() {
        List list = null;
        int size = list.size();
    }

}
