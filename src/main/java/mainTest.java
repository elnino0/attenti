import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.*;

public class mainTest {

    private  HomePage homePage;
    @BeforeMethod
    public void before(){
        driverManager.newDriverSession().get("https://www.metric-conversions.org/");
        homePage = new HomePage(new ElementLocator( By.xpath("/html/body")));
    }

    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                {65},{100},{0}
        };
    }

    @DataProvider
    public Object[][] ValidDataProviderTemperature() {
        return new Object[][]{
                {65},{100},{0},{-1}
        };
    }

    @Test(dataProvider = "ValidDataProviderTemperature")
    public void CelsiusToFahrenheit(int value) throws InterruptedException {
        homePage.getTemp().click();
        TempPage tempPage = new TempPage(new ElementLocator(By.xpath("/html/body")));
        Thread.sleep(1000);
        tempPage.getCelsiusToFahrenheit().focus();
        tempPage.getCelsiusToFahrenheit().click();
        ConvertPage convertPage = new ConvertPage(new ElementLocator(By.xpath("/html/body")));
        Thread.sleep(1000);
        convertPage.getValueBox().focus();
        convertPage.getValueBox().sendKeys("" + value);
        String results = convertPage.getResulteBox().getText();
        System.out.println("results  " + results);
        Float expectedValue = value * 1.8f + 32;
        String actulValueStr =  results.substring(results.indexOf("= ") + 1, results.indexOf("°F"));
        Float actualValue = new Float(actulValueStr);
        Assert.assertEquals(expectedValue, actualValue);

    }

    @Test(dataProvider = "ValidDataProvider")
    public void metersToFeet(int value) throws InterruptedException {
        homePage.getLen().click();
        LengthPage tempPage = new LengthPage(new ElementLocator(By.xpath("/html/body")));
        Thread.sleep(1000);
        tempPage.getMetersToFeet().focus();
        tempPage.getMetersToFeet().click();
        ConvertPage convertPage = new ConvertPage(new ElementLocator(By.xpath("/html/body")));
        Thread.sleep(1000);
        convertPage.getValueBox().focus();
        convertPage.getValueBox().sendKeys("" + value);
        String resulte = convertPage.getResulteBox().getText();
        System.out.println("resolte  " + resulte);
        String feetStr = resulte.substring(resulte.indexOf("= ") + 1,resulte.indexOf("f"));
        String inchStr = resulte.substring(resulte.indexOf("t ") + 1,resulte.indexOf("i"));;
        Float feet = new Float(feetStr);
        Float inc = new Float(inchStr);
        feet = feet + inc * 0.083333f;
        Float expectedValue = value * 3.280840f;
        Assert.assertEquals(feet, expectedValue);
    }

    @Test(dataProvider = "ValidDataProvider")
    public void ouncesToGrams(int value) throws InterruptedException {
        homePage.getWeight().click();
        WeightPage tempPage = new WeightPage(new ElementLocator(By.xpath("/html/body")));
        Thread.sleep(1000);
        tempPage.getOuncesToGrams().focus();
        tempPage.getOuncesToGrams().click();
        ConvertPage convertPage = new ConvertPage(new ElementLocator(By.xpath("/html/body")));
        Thread.sleep(1000);
        convertPage.getValueBox().focus();
        convertPage.getValueBox().sendKeys("" + value);
        String resulte = convertPage.getResulteBox().getText();
        System.out.println("resolte  " + resulte);
        String gramsStr = resulte.substring(resulte.indexOf("= " ) + 1, resulte.indexOf("g"));
        Float grams = new Float(gramsStr);
        double dValue = value * 28.34952f;
        Float expectedValue = RoundNumber.round(dValue ,3);
        Assert.assertEquals(grams, expectedValue);

    }

    @AfterMethod
    public void after(){
        driverManager.getWebDriver().close();
    }



}
