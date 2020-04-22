
package regions;

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
import org.junit.Assume;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PortalsPage;
import pages.RegionsPage;
import pages.SignaturesPage;

public class RegionsTests extends BaseTest {
    private RegionsPage regionsPage;
    
    @Before
    public void setUp() {
        this.regionsPage = dashboardPage.clickOnRegionsLink();
    }
    
    @After
    public void tearDown() {
    }
    
        //Testing heading and URL for Regions link
    @Test
    public void testRegionsLink() {
        regionsPage.clickOnRegionsLink();
               
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure - headings don't match", regionsPage.getPanelHeading().contains("Regions"));
    }
    
    //Testing URL for Frontend BrzeVesti link
    @Test
    public void testBrzeVestiLink() {
       regionsPage.clickOnBrzeVestiLink();
             
       assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());     
       driver.get(Configuration.adminLoginUrl); 
    }    
    
    //Testing heading and URL for Dashboard link
    @Test
    public void testDashboardLink() {
        DashboardPage dashboardPage2 = regionsPage.clickOnDashboardLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
        assertEquals("Failure - headings don't match", "Dashboard", dashboardPage2.getPanelHeading());       
    }
    
    //Testing heading and URL for Signatures link
    @Test
    public void testSignaturesLink() {
        SignaturesPage signaturesPage = regionsPage.clickOnSignaturesLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin/signatures", driver.getCurrentUrl());
        assertEquals("Failure - headings don't match", "Signatures", signaturesPage.getPanelHeading());
    }
    
    //Testing heading and URL for Categories link
    @Test 
    public void testCategoriesLink() {
        CategoriesPage categoriesPage = regionsPage.clickOnCategoriesLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure - headings don't match", categoriesPage.getPanelHeading().contains("Categories"));
    }
    
    //Testing heading and URL for Portals link
    @Test
    public void testPortalsLink() {
        PortalsPage portalsPage = regionsPage.clickOnPortalsLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure - headings don't match", portalsPage.getPanelHeading().contains("Portals"));      
    }
    
    //Testing URL for Sources link
    @Test
    public void testSourcesLink() {
        regionsPage.clickOnSourcesLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin/sources", driver.getCurrentUrl());     
    }
    
    //Testing logout from Regions page
    @Test
    public void testLogOut() {
        regionsPage.clickOnCubesLink();
        regionsPage.clickOnLogoutLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
        driver.get(Configuration.adminLoginUrl);
    
          LoginPage loginPage = new LoginPage(driver, wait);
          dashboardPage = loginPage.login();  
    }
    
    //Testing Add region button
    @Test
    public void addNewRegionTest() {
        regionsPage.addRegion();
        regionsPage.enterRegionName();
        regionsPage.saveNewRegion();
        
        assertTrue("Failure - after creation wrong message appears", regionsPage.getAlertMessage().contains("has been successfully saved"));   
    }
    
    //Testing Back to Regions button
    @Test
    public void backToRegionsTest() {
        regionsPage.addRegion();
        regionsPage.enterRegionName();
        regionsPage.backToRegions();
        
        assertFalse(regionsPage.isAlertBoxPresent());
    }
     
    //Testing reordering first region
    @Test
    public void reorderFirstRegionTest() {

        Actions actions = new Actions(driver);
               
        Action dragAndDrop = actions.clickAndHold(regionsPage.reorderFrom)
        .moveToElement(regionsPage.reorderTo)
        .release(regionsPage.reorderTo)
        .build();

        dragAndDrop.perform();
    }
    
    //Testing reordering third region
    @Test
    public void reorderThirdRegionTest() {
         Actions actions = new Actions(driver);
               
        Action dragAndDrop = actions.clickAndHold(regionsPage.reorderFrom2)
        .moveToElement(regionsPage.reorderTo2)
        .release(regionsPage.reorderTo2)
        .build();

        dragAndDrop.perform();
    }
    
    //Testing editing first region
    @Test
    public void editFirstRegionTest() {
        String regionToBeEdited = regionsPage.editFirstRegion(); 
        regionsPage.getFirstRegionTitleTd();
                                 
        assertFalse("Region titles match", regionsPage.getFirstRegionTitleTd().contains(regionToBeEdited));                 
    }    
    
    //Testing editing first region, without saving (back to regions button)
    @Test
    public void editFirstRegionBackToRegionsTest() {
        regionsPage.editFirstRegionWithoutSaving(); 
        
        assertFalse(regionsPage.isAlertBoxPresent());
    }
    
    //Tesing disabling first region
    @Test
    public void testDisableFirstRegion() {
        String regionToBeDisabled = regionsPage.disableFirstRegion();
      
        Assume.assumeTrue(regionToBeDisabled != "");
              
        assertTrue("Failure - after disabling wrong message appears", regionsPage.getAlertMessage().contains("has been disabled"));
        assertTrue("Failure - wrong region disabled", regionsPage.getAlertMessage().contains(regionToBeDisabled));
    }
    
    //Testing enabling first region
    @Test
    public void testEnableFirstRegion() {
        String regionToBeEnabled = regionsPage.enableFirstRegion();
        
        Assume.assumeTrue(regionToBeEnabled != "");
        
        assertTrue("Failure - after enabling wrong message appears", regionsPage.getAlertMessage().contains("has been enabled"));
        assertTrue("Failure - wrong region enabled", regionsPage.getAlertMessage().contains(regionToBeEnabled));
    }
    
    //Testing disabling last region
    @Test
    public void testDisableLastRegion() {
        String regionToBeDisabled = regionsPage.disableLastRegion();
        
        Assume.assumeTrue(regionToBeDisabled != "");
        
        assertTrue("Failure - after disabling wrong message appears", regionsPage.getAlertMessage().contains("has been disabled"));
        assertTrue("Failure - wrong region disabled", regionsPage.getAlertMessage().contains(regionToBeDisabled));
    }
      
    //Testing enabling last region
    @Test
    public void testEnableLastRegion() {
        String regionToBeEnabled = regionsPage.enableLastRegion();
          
        Assume.assumeTrue(regionToBeEnabled != "");
        
        assertTrue("Failure - after enabling wrong message appears", regionsPage.getAlertMessage().contains("has been enabled"));
        assertTrue("Failure - wrong region enabled", regionsPage.getAlertMessage().contains(regionToBeEnabled));
    }
    
    //Testing disabling random region
    @Test
    public void testDisableRandomRegion() {
        String regionToBeDisabled = regionsPage.disableRandomRegion();
        
        Assume.assumeTrue(regionToBeDisabled != "");
        
        assertTrue("Failure - after disabling wrong message appears", regionsPage.getAlertMessage().contains("has been disabled"));
        assertTrue("Failure - wrong region disabled", regionsPage.getAlertMessage().contains(regionToBeDisabled));
    }
    
    //Testing enabling random region
    @Test
    public void testEnableRandomRegion() {
        String regionToBeEnabled = regionsPage.enableRandomRegion();
        
        Assume.assumeTrue(regionToBeEnabled != "");
        
        assertTrue("Failure - after enabling wrong message appears", regionsPage.getAlertMessage().contains("has been enabled"));
        assertTrue("Failure - wrong region enabled", regionsPage.getAlertMessage().contains(regionToBeEnabled));
    }
    
    //Testing delete option of first region
    @Test
    public void testDeleteFirstRegion() {
        String regionToBeDeleted = regionsPage.deleteFirstRegion();
        Assume.assumeTrue(regionToBeDeleted != "");
               
        assertTrue("Failure - after deletion wrong message appears", regionsPage.getAlertMessage().contains("has been successfully deleted"));
        assertTrue("Failure - wrong region deleted", regionsPage.getAlertMessage().contains(regionToBeDeleted));
    }
    
    //Testing delete option of last region
    @Test
    public void testDeleteLastRegion() {
        String regionToBeDeleted = regionsPage.deleteLastRegion();
        Assume.assumeTrue(regionToBeDeleted != "");
               
        assertTrue("Failure - after deletion wrong message appears", regionsPage.getAlertMessage().contains("has been successfully deleted"));
        assertTrue("Failure - wrong region deleted", regionsPage.getAlertMessage().contains(regionToBeDeleted));
    }
    
    //Testing delete option of random region
    @Test
    public void testDeleteRandomRegion() {
        String regionToBeDeleted = regionsPage.deleteRandomRegion();
        Assume.assumeTrue(regionToBeDeleted != "");
               
        assertTrue("Failure - after deletion wrong message appears", regionsPage.getAlertMessage().contains("has been successfully deleted"));
        assertTrue("Failure - wrong region deleted", regionsPage.getAlertMessage().contains(regionToBeDeleted));
    }

    
}
