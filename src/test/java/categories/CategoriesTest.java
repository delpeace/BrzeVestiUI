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
import java.util.List;
import org.junit.Assume;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.PortalsPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import pages.LoginPage;
import org.junit.Assume;


public class CategoriesTest extends BaseTest {
    private CategoriesPage categoriesPage;  
    
    
    @Before
    public void setUp() {
       this.categoriesPage = dashboardPage.clickOnCategoriesLink();
    }
    
    @After
    public void tearDown() {
    }
 
    //Testing heading and URL for Categories link
    @Test
    public void testCategoriesLink() {
        categoriesPage.clickOnCategoriesLink();
               
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure - headings don't match", categoriesPage.getPanelHeading().contains("Categories"));
    }
    
    //Testing URL for Frontend BrzeVesti link
    @Test
    public void testBrzeVestiLink() {
       categoriesPage.clickOnBrzeVestiLink();
             
       assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());     
       driver.get(Configuration.adminLoginUrl); 
    }    
   
    //Testing heading and URL for Dashboard link
    @Test
    public void testDashboardLink() {
        DashboardPage dashboardPage2 = categoriesPage.clickOnDashboardLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
        assertEquals("Failure - headings don't match", "Dashboard", dashboardPage2.getPanelHeading());       
    }
    
    //Testing heading and URL for Signatures link
    @Test
    public void testSignaturesLink() {
        SignaturesPage signaturesPage = categoriesPage.clickOnSignaturesLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin/signatures", driver.getCurrentUrl());
        assertEquals("Failure - headings don't match", "Signatures", signaturesPage.getPanelHeading());
    }
    
    //Testing heading and URL for Regions link
    @Test 
    public void testRegionsLink() {
        RegionsPage regionsPage = categoriesPage.clickOnRegionsLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure - headings don't match", regionsPage.getPanelHeading().contains("Regions"));
    }
    
    //Testing heading and URL for Portals link
    @Test
    public void testPortalsLink() {
        PortalsPage portalsPage = categoriesPage.clickOnPortalsLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure - headings don't match", portalsPage.getPanelHeading().contains("Portals"));      
    }
    
    //Testing URL for Sources link
    @Test
    public void testSourcesLink() {
        categoriesPage.clickOnSourcesLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin/sources", driver.getCurrentUrl());     
    }
    
    //Testing logout from Categories page
    @Test
    public void testLogOut() {
        categoriesPage.clickOnCubesLink();
        categoriesPage.clickOnLogoutLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
        driver.get(Configuration.adminLoginUrl);
    
          LoginPage loginPage = new LoginPage(driver, wait);
          dashboardPage = loginPage.login();  
    }
    
    //Testing Add category button
    @Test
    public void addNewCategoryTest() {
        categoriesPage.addCategory();
        categoriesPage.enterCategoryName();
        categoriesPage.saveNewCategory();
        
        assertTrue("Failure - after creation wrong message appears", categoriesPage.getAlertMessage().contains("has been successfully saved"));   
    }
    
    //Testing Back to Categories button
    @Test
    public void backToCategoriesTest() {
        categoriesPage.addCategory();
        categoriesPage.enterCategoryName();
        categoriesPage.backToCategories();
        
        assertFalse(categoriesPage.isAlertBoxPresent());
    }
      
    //Testing reordering first category
    @Test
    public void reorderFirstCategoryTest() {

        Actions actions = new Actions(driver);
               
        Action dragAndDrop = actions.clickAndHold(categoriesPage.reorderFrom)
        .moveToElement(categoriesPage.reorderTo)
        .release(categoriesPage.reorderTo)
        .build();

        dragAndDrop.perform();
    }
    
    //Testing reordering third category
    @Test
    public void reorderThirdCategoryTest() {
         Actions actions = new Actions(driver);
               
        Action dragAndDrop = actions.clickAndHold(categoriesPage.reorderFrom2)
        .moveToElement(categoriesPage.reorderTo2)
        .release(categoriesPage.reorderTo2)
        .build();

        dragAndDrop.perform();
    }
    
    //Testing editing first category
    @Test
    public void editFirstCategoryTest() {
        String categoryToBeEdited = categoriesPage.editFirstCategory(); 
        String categoryName = categoriesPage.getFirstCategoryTitleTd();
                        
       System.out.println("Stara kategorija: "+ categoryToBeEdited);
       System.out.println("Nova kategorija: " + categoryName);
         
        assertFalse("Category titles match", categoriesPage.getFirstCategoryTitleTd().contains(categoryToBeEdited));                 
    }    
    
    //Testing editing first category, without saving (back to categories button)
    @Test
    public void editFirstCategoryBackToCategoriesTest() {
        categoriesPage.editFirstCategoryWithoutSaving(); 
        
        assertFalse(categoriesPage.isAlertBoxPresent());
    }
    
    //Tesing disabling first category
    @Test
    public void testDisableFirstCategory() {
        String categoryToBeDisabled = categoriesPage.disableFirstCategory();
      
        Assume.assumeTrue(categoryToBeDisabled != "");
              
        assertTrue("Failure - after disabling wrong message appears", categoriesPage.getAlertMessage().contains("has been disabled"));
        assertTrue("Failure - wrong category disabled", categoriesPage.getAlertMessage().contains(categoryToBeDisabled));
    }
    
    //Testing enabling first category
    @Test
    public void testEnableFirstCategory() {
        String categoryToBeEnabled = categoriesPage.enableFirstCategory();
        
        Assume.assumeTrue(categoryToBeEnabled != "");
        
        assertTrue("Failure - after enabling wrong message appears", categoriesPage.getAlertMessage().contains("has been enabled"));
        assertTrue("Failure - wrong category enabled", categoriesPage.getAlertMessage().contains(categoryToBeEnabled));
    }
    
    //Testing disabling last category
    @Test
    public void testDisableLastCategory() {
        String categoryToBeDisabled = categoriesPage.disableLastCategory();
        
        Assume.assumeTrue(categoryToBeDisabled != "");
        
        assertTrue("Failure - after disabling wrong message appears", categoriesPage.getAlertMessage().contains("has been disabled"));
        assertTrue("Failure - wrong category disabled", categoriesPage.getAlertMessage().contains(categoryToBeDisabled));
    }
    
    //Testing enabling last category
    @Test
    public void testEnableLastCategory() {
        String categoryToBeEnabled = categoriesPage.enableLastCategory();
//        
//      System.out.println("Da li stampas ista? " + categoriesPage.getStatusValuesOfCategory(lastRow));
//        
        Assume.assumeTrue(categoryToBeEnabled != "");
        
        assertTrue("Failure - after enabling wrong message appears", categoriesPage.getAlertMessage().contains("has been enabled"));
        assertTrue("Failure - wrong category enabled", categoriesPage.getAlertMessage().contains(categoryToBeEnabled));
    }
    
    //Testing disabling random category
    @Test
    public void testDisableRandomCategory() {
        String categoryToBeDisabled = categoriesPage.disableRandomCategory();
        
        Assume.assumeTrue(categoryToBeDisabled != "");
        
        assertTrue("Failure - after disabling wrong message appears", categoriesPage.getAlertMessage().contains("has been disabled"));
        assertTrue("Failure - wrong category disabled", categoriesPage.getAlertMessage().contains(categoryToBeDisabled));
    }
    
    //Testing enabling random category
    @Test
    public void testEnableRandomCategory() {
        String categoryToBeEnabled = categoriesPage.enableRandomCategory();
        
        Assume.assumeTrue(categoryToBeEnabled != "");
        
        assertTrue("Failure - after enabling wrong message appears", categoriesPage.getAlertMessage().contains("has been enabled"));
        assertTrue("Failure - wrong category enabled", categoriesPage.getAlertMessage().contains(categoryToBeEnabled));
    }
    
    //Testing delete option of first category
    @Test
    public void testDeleteFirstCategory() {
        String categoryToBeDeleted = categoriesPage.deleteFirstCategory();
        Assume.assumeTrue(categoryToBeDeleted != "");
               
        assertTrue("Failure - after deletion wrong message appears", categoriesPage.getAlertMessage().contains("has been successfully deleted"));
        assertTrue("Failure - wrong category deleted", categoriesPage.getAlertMessage().contains(categoryToBeDeleted));
    }
    
    //Testing delete option of last category
    @Test
    public void testDeleteLastCategory() {
        String categoryToBeDeleted = categoriesPage.deleteLastCategory();
        Assume.assumeTrue(categoryToBeDeleted != "");
               
        assertTrue("Failure - after deletion wrong message appears", categoriesPage.getAlertMessage().contains("has been successfully deleted"));
        assertTrue("Failure - wrong category deleted", categoriesPage.getAlertMessage().contains(categoryToBeDeleted));
    }
    
    //Testing delete option of random category
    @Test
    public void testDeleteRandomCategory() {
        String categoryToBeDeleted = categoriesPage.deleteRandomCategory();
        Assume.assumeTrue(categoryToBeDeleted != "");
               
        assertTrue("Failure - after deletion wrong message appears", categoriesPage.getAlertMessage().contains("has been successfully deleted"));
        assertTrue("Failure - wrong category deleted", categoriesPage.getAlertMessage().contains(categoryToBeDeleted));
    }
    
    
}








