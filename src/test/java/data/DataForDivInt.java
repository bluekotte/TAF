package data;

import org.testng.annotations.DataProvider;

public class DataForDivInt {
    @DataProvider(name = "DataForDivInt")
    public static Object[][] dataForDivInt() {
        return new Object[][]{
                {4, 2, 2},
                {-6, -3, 2},
                {5, 0, 0}
        };
    }
}
