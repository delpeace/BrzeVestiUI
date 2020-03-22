package base;

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


public class BaseTest {
    
    public BaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 4);
        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");
        
        //Login start
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(Configuration.validEmail);
        
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(Configuration.validPassword);
        
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();
        //Login end
    }
    
   
        
    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    
}
