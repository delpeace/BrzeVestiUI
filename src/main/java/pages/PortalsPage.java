package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PortalsPage extends AdminPage {
    private WebDriver driver;
        
    public PortalsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

}
