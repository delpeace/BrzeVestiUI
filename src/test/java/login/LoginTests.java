package login;

import base.BaseTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import pages.LoginPage;


public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfullLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        
        assertEquals("Failure - URLs don't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
        
        String expectedHeading = "Dashboard";
        String actualHeading = driver.findElement(By.className("panel-heading")).getText();
        assertEquals("Failure - headings don't match", expectedHeading, actualHeading);
    }
}
