import org.openqa.selenium.By;

public class LengthPage extends ElementWrapper {

    private ElementWrapper metersToFeet;

    public LengthPage(ElementLocator locator) {
        super(locator);

    }

    public ElementWrapper getMetersToFeet() {
        this.metersToFeet = findChildElement(new ElementLocator(By.xpath("//*[@id='popLinks']/ol/li[1]/a")));
        return metersToFeet;
    }
}
