import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverManager {

    private static WebDriver driver;

    public  static WebDriver newDriverSession(){
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        return driver;
    }

    public  static  WebDriver getWebDriver(){
        if(driver == null){
            driver = new ChromeDriver();
            driver.manage().window().fullscreen();
        }

        return driver;
    }

    public void close(){
        driver.close();
    }

    public  static  void navigate(String url){
        getWebDriver().get(url);
    }

}
