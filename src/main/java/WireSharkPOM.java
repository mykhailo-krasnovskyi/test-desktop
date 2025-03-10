import io.appium.java_client.AppiumBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class WireSharkPOM {

    private WindowsDriver driver = null;

    public WireSharkPOM(WindowsDriver wd) {
        driver = wd;
    }

    public WebElement nextButton() {
        return driver.findElement(By.name("Next >"));
    }

    public WebElement backButton() {
        return driver.findElement(AppiumBy.name("< Back"));
    }

    public WebElement cancelButton() {
        return driver.findElement(AppiumBy.name("Cancel"));
    }

    public WebElement notedButton() {
        return driver.findElement(AppiumBy.name("Noted"));
    }

}
