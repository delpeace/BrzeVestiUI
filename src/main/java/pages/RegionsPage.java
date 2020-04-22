package pages;

import framework.Helper;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegionsPage extends AdminPage {
    
    private By panelHeading = By.className("panel-heading");
    private By regionsLink = By.partialLinkText("Region");
    private By addRegionButton = By.className("pull-right");
    private By regionTitleField = By.id("title");
    private By saveRegionButton = By.id("save-region-button");
    private By backToRegionsButton = By.id("back-button");
    private By confirmDisableButton = By.xpath("//*[@id=\"regionDisableDialog\"]/div/div/div[3]/button[2]");                                                    
    private By confirmEnableButton = By.xpath("//*[@id=\"regionEnableDialog\"]/div/div/div[3]/button[2]");
    private By confirmDeleteButton = By.xpath("//*[@id=\"regionDeleteDialog\"]/div/div/div[3]/button[2]");
    private By regionsTable = By.xpath("//*[@id=\"regionsTable\"]/tbody");
    private By tableRow = By.tagName("tr");
    public By alertBox = By.className("alert");
    public By firstRegionTitleTd = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[3]");       
    
        
    public RegionsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void addRegion() {
        wait.until(ExpectedConditions.elementToBeClickable(addRegionButton)).click();
    }
        
    public void enterRegionName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(regionTitleField)).sendKeys(Helper.getRandomRegionText());
    }    
    
    public void backToRegions() {
        wait.until(ExpectedConditions.elementToBeClickable(backToRegionsButton)).click();
    }  

    public boolean isAlertBoxPresent() {
        try {
          driver.findElement(alertBox);
          return true;
        }
      catch (org.openqa.selenium.NoSuchElementException e) {
          return false;
        }
    }

    public void saveNewRegion() {
       wait.until(ExpectedConditions.elementToBeClickable(saveRegionButton)).click();
    }      

    public String getAlertMessage() {
        return driver.findElement(alertBox).getText();
    }
    
    //WebElemens for reordering first region
    public WebElement reorderFrom = driver.findElement(By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[1]/span"));

    public WebElement reorderTo = driver.findElement(By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[4]"));

    //WebElements for reordering third region
     public WebElement reorderFrom2 = driver.findElement(By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[3]/td[1]/span"));

    public WebElement reorderTo2 = driver.findElement(By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]"));


    public void clearTitleField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(regionTitleField)).clear();   
    }

    public String getFirstRegionTitleTd() {
        return driver.findElement(firstRegionTitleTd).getText();
    }


    public List<WebElement> getAllRows() {
        if (driver.findElements(tableRow).size() !=0) {
            WebElement table = driver.findElement(regionsTable);
            return table.findElements(tableRow);
        }
        return new ArrayList<>();
    }


    public String editFirstRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.size() == 0){
            return "";
        }
        WebElement firstRow = rows.get(0);
        String region = getRegionFromRow(firstRow);

        this.clickOnEditButtton(firstRow);
        this.clearTitleField();          
        this.enterRegionName();
        this.saveNewRegion();
        return region;
    }

    public String editFirstRegionWithoutSaving() {
        List<WebElement> rows = this.getAllRows();
        if (rows.size() == 0){
            return "";
        }
        WebElement firstRow = rows.get(0);
        String region = getRegionFromRow(firstRow);

        this.clickOnEditButtton(firstRow);
        this.clearTitleField();          
        this.enterRegionName();
        this.backToRegions();
        return "";
    }

    public String getRegionFromRow(WebElement row) {
        return row.findElement(By.xpath(".//td[3]")).getText();
    }

    private void clickOnEditButtton(WebElement row) {
        row.findElement(By.xpath(".//td[5]/div/a")).click();
    }

    private void clickOnDisableButton(WebElement row) {
        row.findElement(By.xpath(".//td[5]/div/button[1]")).click();
    }

    private void confirmDisable() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmDisableButton)).click();
    }

    private void clickOnEnableButton(WebElement row) {
        row.findElement(By.xpath(".//td[5]/div/button[1]")).click();
    }   

    private void confirmEnable() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmEnableButton)).click();
    }

    private void clickOnDeleteButton(WebElement row) {
        row.findElement(By.xpath(".//td[5]/div/button[2]")).click();
    }

    private void confirmDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
    }


    public String getStatusValuesOfRegion(WebElement row) {
        return row.findElement(By.xpath(".//td[4]/span")).getText();
    }


    public String disableFirstRegion() {
        List<WebElement> rows = this.getAllRows();
        WebElement firstRow = rows.get(0);
        String region = getRegionFromRow(firstRow);
        if ("E".equals(getStatusValuesOfRegion(firstRow))){         
            this.clickOnDisableButton(firstRow);
            this.confirmDisable();
            return region;
        } return "";
    }

    public String enableFirstRegion() {
        List<WebElement> rows = this.getAllRows();
        WebElement firstRow = rows.get(0);
        String region = getRegionFromRow(firstRow);
        if ("D".equals(getStatusValuesOfRegion(firstRow))){          
            this.clickOnEnableButton(firstRow);
            this.confirmEnable();
            return region;
        } return "";
    }

    public String disableLastRegion() {
        List<WebElement> rows = this.getAllRows();
        WebElement lastRow = rows.get(rows.size() - 1);
        String region = getRegionFromRow(lastRow);
        if ("E".equals(getStatusValuesOfRegion(lastRow))){
            this.clickOnDisableButton(lastRow);
            this.confirmDisable();
            return region;
        } return "";
    }


    public String enableLastRegion() {
        List<WebElement> rows = this.getAllRows();
        WebElement lastRow = rows.get(rows.size() - 1);
        String region = getRegionFromRow(lastRow);
        if ("D".equals(getStatusValuesOfRegion(lastRow))){
            this.clickOnEnableButton(lastRow);
            this.confirmEnable();
            return region;
        } 
            return "";
    }


    public String disableRandomRegion() {
        List<WebElement> rows = this.getAllRows();
        WebElement randomRow = rows.get(Helper.getRandomInteger2(rows.size() - 1));
        String region = getRegionFromRow(randomRow);
        if ("E".equals(getStatusValuesOfRegion(randomRow))){
            this.clickOnDisableButton(randomRow);
            this.confirmDisable();
            return region;
        } return "";
    }

    public String enableRandomRegion() {
        List<WebElement> rows = this.getAllRows();
        WebElement randomRow = rows.get(Helper.getRandomInteger2(rows.size() - 1));
        String region = getRegionFromRow(randomRow);
         if ("D".equals(getStatusValuesOfRegion(randomRow))){
            this.clickOnEnableButton(randomRow);
            this.confirmEnable();
            return region;
        } return "";
    }

    public String deleteFirstRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.size() == 0){
            return "";
        }
        WebElement firstRow = rows.get(0);
        String region = getRegionFromRow(firstRow);

        this.clickOnDeleteButton(firstRow);
        this.confirmDelete();
        return region;
    }

    public String deleteLastRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.size() == 0){
            return "";
        }
        WebElement lastRow = rows.get(rows.size() - 1);

        String region = getRegionFromRow(lastRow);
        this.clickOnDeleteButton(lastRow);
        this.confirmDelete();
        return region;
    }

    public String deleteRandomRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.size() == 0){
            return "";
        }
        WebElement randomRow = rows.get(Helper.getRandomInteger2(rows.size() - 1));

        String region = getRegionFromRow(randomRow);
        this.clickOnDeleteButton(randomRow);
        this.confirmDelete();
        return region;
    }
    
}
