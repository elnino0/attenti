import org.openqa.selenium.By;

public class TempPage extends ElementWrapper {

    private ElementWrapper CelsiusToFahrenheit;

    public TempPage(ElementLocator locator) {
        super(locator);
        this.CelsiusToFahrenheit = findChildElement(new ElementLocator(By.xpath("//*[@id='popLinks']/ol/li[1]/a")));
    }

    public ElementWrapper getCelsiusToFahrenheit() {
        this.CelsiusToFahrenheit = findChildElement(new ElementLocator(By.xpath("//*[@id='popLinks']/ol/li[1]/a")));
        return CelsiusToFahrenheit;
    }
}
