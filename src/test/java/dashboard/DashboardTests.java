
package dashboard;

import base.BaseTest;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SignaturesPage;


public class DashboardTests extends BaseTest {
    
    @Test
    public void testSignaturesLink() {
        LoginPage loginPage = new LoginPage(driver, wait);
        DashboardPage dashboardPage = loginPage.login();
        SignaturesPage signaturesPage = dashboardPage.clickOnSignaturesLink();
        
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin/signatures", driver.getCurrentUrl());
        assertEquals("Failure - headings don't match", "Signatures", signaturesPage.getPanelHeading());
        
    }
    
    @Test
    public void testCategoriesLink() {
        LoginPage loginPage = new LoginPage(driver, wait);
        DashboardPage dashboardPage = loginPage.login();
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
   
        System.out.println("'" + categoriesPage.getPanelHeading() + "'");
    
        assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure - headings don't match", categoriesPage.getPanelHeading().contains("Categories"));
    }    
    
    @Test
    public void testCubesLink() {
        LoginPage loginPage = new LoginPage(driver, wait);
        DashboardPage dashboardPage = loginPage.login();
        dashboardPage.clickOnCubesLink();
        dashboardPage.clickOnLogoutLink();
        
 
    
       assertEquals("Failure - Urls don't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
    }
}

    
        
        
