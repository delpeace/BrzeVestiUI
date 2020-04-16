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


public class CategoriesTest extends BaseTest {
    private CategoriesPage categoriesPage;
//    //Needs to be static so we can call it from static method
//    public static WebDriver driver;
//    public static WebDriverWait wait;
//    
    
    
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
    }
    
    
    //Testing Add category button
    @Test
    public void addNewCategoryTest() {
        categoriesPage.addCategory();
        categoriesPage.enterCategoryName();
        categoriesPage.saveNewCategory();
        
        assertTrue("Failure - after creation wrong message appears", categoriesPage.getAlertMessage().contains("has been successfully saved"));   
    }
    
    //Testing Back to Categories button - NE RADI!!!
    @Test
    public void backToCategoriesTest() {
        categoriesPage.addCategory();
        categoriesPage.enterCategoryName();
        categoriesPage.backToCategories();
        
    //    assertFalse("Failure - new category is created", categoriesPage.getAlertMessage().contains("milica"));
 
        
//        List<String> categoryValues = categoriesPage.getCategoryValues();
//        for(String category : categoryValues) {
//            assertEquals("Failure - new category is created", category, categoriesPage.getNewCategoryName());
//        }
        
     }
    
    //Work in progress - Testing editing first category
    @Test
    public void editFirstCategoryTest() {
        String categoryToBeEdited = categoriesPage.editFirstCategory(); 
        String categoryName = categoriesPage.getFirstCategoryTitleTd();
                        
        System.out.println("Stara kategorija: "+ categoryToBeEdited);
        System.out.println("Nova kategorija: " + categoryName);
        
       // assertTrue("Titles don't match", categoriesPage.getFirstCategoryTitleTd().contains(categoryToBeEdited));
                //categoriesPage.getFirstCategoryTitleTd().contains("milica")); 
  
        assertFalse("Category titles match", categoriesPage.getFirstCategoryTitleTd().contains(categoryToBeEdited));        
                
    }
    
    
    //Tesing disabling first category
    @Test
    public void testDisableFirstCategory() {
        String categoryToBeDisabled = categoriesPage.disableFirstCategory();
        
        assertTrue("Failure - after disabling wrong message appears", categoriesPage.getAlertMessage().contains("has been disabled"));
        assertTrue("Failure - wrong category disabled", categoriesPage.getAlertMessage().contains(categoryToBeDisabled));
    }
    
    
    //Testing enabling first category
    @Test
    public void testEnableFirstCategory() {
        String categoryToBeEnabled = categoriesPage.enableFirstCategory();
        
        assertTrue("Failure - after enabling wrong message appears", categoriesPage.getAlertMessage().contains("has been enabled"));
        assertTrue("Failure - wrong category enabled", categoriesPage.getAlertMessage().contains(categoryToBeEnabled));
    }
    
    
    //Testing disabling last category
    @Test
    public void testDisableLastCategory() {
        String categoryToBeDisabled = categoriesPage.disableLastCategory();
        
        assertTrue("Failure - after disabling wrong message appears", categoriesPage.getAlertMessage().contains("has been disabled"));
        assertTrue("Failure - wrong category disabled", categoriesPage.getAlertMessage().contains(categoryToBeDisabled));
    }
    
    
    //Testing enabling last category
    @Test
    public void testEnableLastCategory() {
        String categoryToBeEnabled = categoriesPage.enableLastCategory();
        
        assertTrue("Failure - after enabling wrong message appears", categoriesPage.getAlertMessage().contains("has been enabled"));
        assertTrue("Failure - wrong category enabled", categoriesPage.getAlertMessage().contains(categoryToBeEnabled));
    }
    
    
    //Tesing disabling random category
    @Test
    public void testDisableRandomCategory() {
        String categoryToBeDisabled = categoriesPage.disableRandomCategory();
        
        assertTrue("Failure - after disabling wrong message appears", categoriesPage.getAlertMessage().contains("has been disabled"));
        assertTrue("Failure - wrong category disabled", categoriesPage.getAlertMessage().contains(categoryToBeDisabled));
    }
    
    
    
    //Testing delete option of first category
    @Test
    public void testDeleteFirstCategory() {
        String categoryToBeDeleted = categoriesPage.deleteFirstCategory();
        Assume.assumeTrue(categoryToBeDeleted != "");
               
        assertTrue("Failure - after deletion wrong message appears", categoriesPage.getAlertMessage().contains("has been successfully deleted"));
        assertTrue("Failure - wrong signature deleted", categoriesPage.getAlertMessage().contains(categoryToBeDeleted));
    }
    
    //Testing delete option of last category
    @Test
    public void testDeleteLastCategory() {
        String categoryToBeDeleted = categoriesPage.deleteLastCategory();
        Assume.assumeTrue(categoryToBeDeleted != "");
               
        assertTrue("Failure - after deletion wrong message appears", categoriesPage.getAlertMessage().contains("has been successfully deleted"));
        assertTrue("Failure - wrong signature deleted", categoriesPage.getAlertMessage().contains(categoryToBeDeleted));
    }
    
    
    //Testing delete option of random category
    @Test
    public void testDeleteRandomCategory() {
        String categoryToBeDeleted = categoriesPage.deleteRandomCategory();
        Assume.assumeTrue(categoryToBeDeleted != "");
               
        assertTrue("Failure - after deletion wrong message appears", categoriesPage.getAlertMessage().contains("has been successfully deleted"));
        assertTrue("Failure - wrong signature deleted", categoriesPage.getAlertMessage().contains(categoryToBeDeleted));
    }
    
    
}








