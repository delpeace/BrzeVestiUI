
package first;

import framework.Configuration;
import java.io.IOException;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest {
        
   
/*    @Test
    public void hello() throws IOException {
        Configuration.init();
        System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://bvtest.school.cubes.rs/login");
        
       assertEquals(driver.getCurrentUrl(), "http://bvtest.school.cubes.rs/login");
        
      //  assertEquals("test", "test");
        
        driver.quit();
        
    } 
*/

    @Test
    public void checkLoginPageTitle() throws IOException {
        Configuration.init();
        System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://bvtest.school.cubes.rs/login");
        
        String expectedTitle = "Brze vesti admin";
        String actualTitle = driver.getTitle();
        
        assertEquals(expectedTitle, actualTitle);
        
        driver.quit();
    }
    
    @Test
    public void checkLoginPageUrl() throws IOException {
        Configuration.init();
        System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://bvtest.school.cubes.rs/login");
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
        
        assertEquals(expectedUrl, actualUrl);
        
        driver.quit();
    }
    
    @Test
    public void testLogin() throws IOException {
        Configuration.init();
        System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://bvtest.school.cubes.rs/login");
        
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(Configuration.validEmail);
        
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(Configuration.validPassword);
        
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();
        
        assertEquals("http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
        
        
        driver.quit();
    }
    
    
}










