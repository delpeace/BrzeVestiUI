
package regions;

import static categories.CategoriesTest.driver;
import static categories.CategoriesTest.wait;
import framework.Configuration;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseTest;
import framework.Helper;

public class RegionsTests extends BaseTest {
    
    @Before
    public void setUp() {
        WebElement regionsLink = driver.findElement(By.partialLinkText("Region"));
        regionsLink.click();
    }
    
    
    @Test
    public void addNewRegionTest() {
        driver.findElement(By.className("pull-right")).click();
        String newRegionTitle = Helper.getRandomText();
        driver.findElement(By.id("title")).sendKeys(newRegionTitle);
        driver.findElement(By.id("save-region-button")).click();
        
        WebElement message = driver.findElement(By.className("alert-success"));
        
        assertEquals("Not found alert success", "Region \"" + newRegionTitle +"\" has been successfully saved!", message.getText());
        
    }
    
}
