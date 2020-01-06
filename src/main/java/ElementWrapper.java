import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementWrapper {

    private ElementLocator locator;
    private WebElement element;

    private ElementWrapper(WebElement element){
        this.element = element;
    }

    public ElementWrapper(ElementLocator locator) {
        this.locator = locator;
        this.element = driverManager.getWebDriver().findElement(locator.getBy());
    }

    public void focus(){
        new Actions(driverManager.getWebDriver()).moveToElement(element).perform();
    }

    public String getText(){
        return this.element.getText();
    }
    public void click(){
        this.element.click();
    }

    public  void  sendKeys(String s){
        this.element.sendKeys(s);
    }

    public ElementWrapper findChildElement(ElementLocator locator){
        return  new ElementWrapper(this.element.findElement(locator.getBy()));
    }
}
