import org.openqa.selenium.By;

public class WeightPage extends ElementWrapper {

    private ElementWrapper ouncesToGrams;

    public WeightPage(ElementLocator locator) {
        super(locator);
    }

    public ElementWrapper getOuncesToGrams() {
        this.ouncesToGrams = findChildElement(new ElementLocator(By.xpath("//*[@id='popLinks']/ol/li[5]/a")));
        return ouncesToGrams;
    }
}
