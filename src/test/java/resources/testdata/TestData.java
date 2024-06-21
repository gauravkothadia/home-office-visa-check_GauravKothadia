package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "searchCriteria")
    public Object[][] getData() {
        Object[][] data = new Object[][]{

                {}
        };
        return data;
    }
}
