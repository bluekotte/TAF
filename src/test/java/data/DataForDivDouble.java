package data;

import org.testng.annotations.DataProvider;

public class DataForDivDouble {
    @DataProvider(name = "dataForDivDouble")
    public static Object[][] dataForDivDouble() {
        return new Object[][]{
                {4.2, 2.1, 2},
                {-6.3, -2.1, 3},
                {5.1, 0, Double.POSITIVE_INFINITY},
        };
    }
}
