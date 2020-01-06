import org.openqa.selenium.By;

public class HomePage extends ElementWrapper {

    private ElementWrapper temp;
    private ElementWrapper len;
    private ElementWrapper weight;
    public HomePage(ElementLocator locator) {
        super(locator);
        this.temp = findChildElement(new ElementLocator(By.xpath("//*[@id='typeMenu']/a[1]")));
        this.len = findChildElement(new ElementLocator(By.xpath("//*[@id='typeMenu']/a[3]")));
        this.weight = findChildElement(new ElementLocator(By.xpath("//*[@id='typeMenu']/a[2]")));
    }

    public ElementWrapper getTemp() {
        return temp;
    }

    public ElementWrapper getLen() {
        return len;
    }

    public ElementWrapper getWeight() {
        return weight;
    }
}
