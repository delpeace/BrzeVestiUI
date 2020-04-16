package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegionsPage extends AdminPage {
    private WebDriver driver;
        
    public RegionsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

}
