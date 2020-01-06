import org.openqa.selenium.By;

public class ElementLocator {

    private By by;

    public ElementLocator(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
