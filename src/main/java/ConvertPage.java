import org.openqa.selenium.By;

public class ConvertPage extends ElementWrapper {

    private ElementWrapper valueBox;
    private ElementWrapper resulteBox;

    public ConvertPage(ElementLocator locator) {
        super(locator);
    }

    public ElementWrapper getValueBox() {
        this.valueBox = findChildElement(new ElementLocator(By.xpath("//*[@id='argumentConv']")));
        return valueBox;
    }

    public ElementWrapper getResulteBox() {
        this.resulteBox = findChildElement(new ElementLocator(By.xpath("//*[@id='answer']")));
        return resulteBox;
    }
}
