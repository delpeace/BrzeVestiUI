package categories;

import framework.Configuration;
import framework.Helper;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseTest;


public class CategoriesTest extends BaseTest {
    //Needs to be static so we can call it from static method
    public static WebDriver driver;
    public static WebDriverWait wait;
    
    
    
    @Before
    public void setUp() {
        WebElement categoriesLink = driver.findElement(By.partialLinkText("Categor"));
        categoriesLink.click();
    }
    
    @After
    public void tearDown() {
    }
 
    @Test
    public void addNewCategoryTest() throws IOException {
  
        WebElement addCategoryButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addCategoryButton.click();
        
        WebElement categoryTitleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
        categoryTitleField.sendKeys(Helper.getRandomText());
        
        WebElement saveCategoryButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("save-category-button")));
        saveCategoryButton.click();
        
    }
    
    @Test
    public void editFirstCategoryTest() {
   
        
        WebElement editFirstCategoryButton = driver.findElement(By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[5]/div/a"));
        editFirstCategoryButton.click();
        
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.clear();
        String newTitle = Helper.getRandomText();
        titleField.sendKeys(newTitle);
        
        WebElement saveCategoryButton = driver.findElement(By.id("save-category-button"));
        saveCategoryButton.click();
        
        WebElement firstCategoryTitleTd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[3]")));
        
        assertEquals("Titles don't match", newTitle, firstCategoryTitleTd.getText()); 
  
    }
    
    
    
}








