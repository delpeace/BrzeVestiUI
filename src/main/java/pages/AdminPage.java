
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminPage {
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected By brzeVestiLink = By.xpath("//*[@id=\"app-layout\"]/nav/div/div[1]/a");
    protected By dashboardLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");
    protected By signaturesLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[2]/a");
    protected By categoriesLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[3]/a");
    protected By regionsLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[4]/a");
    protected By portalsLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[5]/a");
    protected By sourcesLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[6]/a");
    protected By cubesLink = By.className("dropdown-toggle");
    protected By logoutLink = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li/a");
   
    private By panelHeading = By.className("panel-heading");
    
    public AdminPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public void clickOnBrzeVestiLink() {
        driver.findElement(brzeVestiLink).click();
    }
    
    public DashboardPage clickOnDashboardLink() {
        driver.findElement(dashboardLink).click();
        return new DashboardPage(driver, wait);
    }
    
    public SignaturesPage clickOnSignaturesLink() {
        driver.findElement(signaturesLink).click();
        return new SignaturesPage(driver, wait);
    }
    
    public CategoriesPage clickOnCategoriesLink() {
        driver.findElement(categoriesLink).click();
        return new CategoriesPage(driver, wait);
    }
    
    public RegionsPage clickOnRegionsLink() {
        driver.findElement(regionsLink).click();
        return new RegionsPage(driver, wait);
    }
    
    public PortalsPage clickOnPortalsLink() {
        driver.findElement(portalsLink).click();
        return new PortalsPage(driver, wait);
    }
    
    public SourcesPage clickOnSourcesLink() {
        driver.findElement(sourcesLink).click();
        return new SourcesPage(driver, wait);
    }

    public String getPanelHeading() {
        return driver.findElement(panelHeading).getText();
    }
    
    public DashboardPage clickOnCubesLink() {
        driver.findElement(cubesLink).click();
        return new DashboardPage(driver, wait);
    }
        
    public DashboardPage clickOnLogoutLink() {
        driver.findElement(logoutLink).click();
        return new DashboardPage(driver, wait);
    }    
        
  
    //}
    
}
