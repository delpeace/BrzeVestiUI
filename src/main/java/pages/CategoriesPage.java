package pages;

import framework.Helper;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;


public class CategoriesPage extends AdminPage {
    
        private By panelHeading = By.className("panel-heading");
        private By categoriesLink = By.partialLinkText("Categor");
        private By addCategoryButton = By.className("pull-right");
        private By categoryTitleField = By.id("title");
        private By saveCategoryButton = By.id("save-category-button");
        private By backToCategoriesButton = By.id("back-button");
        private By confirmDisableButton = By.xpath("//*[@id=\"categoryDisableDialog\"]/div/div/div[3]/button[2]");
        private By confirmEnableButton = By.xpath("//*[@id=\"categoryEnableDialog\"]/div/div/div[3]/button[2]");
        private By confirmDeleteButton = By.xpath("//*[@id=\"categoryDeleteDialog\"]/div/div/div[3]/button[2]");
        private By categoriesTable = By.xpath("//*[@id=\"categoriesTable\"]/tbody");
        private By tableRow = By.tagName("tr");
        //private By tdCategory = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[3]");
        private By alertBox = By.className("alert");
        public By firstCategoryTitleTd = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[3]");
        public By reorderFrom = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[1]/span");
        public By reorderTo = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[8]");


//    private WebDriver driver;

//        
        CategoriesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
        
        public void addCategory() {
            wait.until(ExpectedConditions.elementToBeClickable(addCategoryButton)).click();
        }
        
        public void enterCategoryName() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(categoryTitleField)).sendKeys(Helper.getRandomText());
        }
        
        public String getFirstCategoryTitleName() {
            return driver.findElement(categoryTitleField).getText();
        }
        
        
        public void backToCategories() {
            wait.until(ExpectedConditions.elementToBeClickable(backToCategoriesButton)).click();
        }        
        
        public void saveNewCategory() {
           wait.until(ExpectedConditions.elementToBeClickable(saveCategoryButton)).click();
        }      
        
        public String getAlertMessage() {
            return driver.findElement(alertBox).getText();
        }
        
        
        //Trying to figure out reordering
        
        
         //Using Action class for drag and drop.		
         Actions act=new Actions(driver);					

	//Dragged and dropped.		
        act.dragAndDrop(reorderFrom, reorderTo).build().perform();
        
      //  public class Actions {
      //      Actions act = new Actions(driver);
            
      //     act.dragAndDrop(reorderFrom,reorderTo).build().perform();
      //  }
        
        public String getNewCategoryName() {
            return driver.findElement(categoryTitleField).getText();
        }
        
        public void clearTitleField() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(categoryTitleField)).clear();   
        }
              
        public String getFirstCategoryTitleTd() {
            return driver.findElement(firstCategoryTitleTd).getText();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(firstCategoryTitleTd)).getText();
            //return this.getFirstCategoryTitleTd();
        }
                

                
                
        
        public List<WebElement> getAllRows() {
            if (driver.findElements(tableRow).size() !=0) {
                WebElement table = driver.findElement(categoriesTable);
                return table.findElements(tableRow);
            }
            return new ArrayList<>();
        }
        
        public List<String> getCategoryValues() {
            List<String> categoryValues = new ArrayList<>();
            List<WebElement> rows = this.getAllRows();
            for (WebElement row : rows) {
//                WebElement portalTd = row.findElement(By.xpath(".//td[2]"));
//                String portalValue = portalTd.getText();
//                portalValues.add(portalValue);
//                
                categoryValues.add(row.findElement(By.xpath(".//td[3]")).getText());
            }
            
            return categoryValues;
        }
        
        public String editFirstCategory() {
            List<WebElement> rows = this.getAllRows();
            if (rows.size() == 0){
                return "";
            }
            WebElement firstRow = rows.get(0);
            String category = getCategoryFromRow(firstRow);
            
            this.clickOnEditButtton(firstRow);
            this.clearTitleField();
            
   //        String newTitle = getFirstCategoryTitleTd();
            
            this.enterCategoryName();
            this.saveNewCategory();
            return category;
        }
        
            
       
        
//        WebElement editFirstCategoryButton = driver.findElement(By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[5]/div/a"));
//        editFirstCategoryButton.click();
//        
//        WebElement titleField = driver.findElement(By.id("title"));
//        titleField.clear();
//        String newTitle = Helper.getRandomText();
//        titleField.sendKeys(newTitle);
//        
//        WebElement saveCategoryButton = driver.findElement(By.id("save-category-button"));
//        saveCategoryButton.click();
//        
//        WebElement firstCategoryTitleTd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[3]")));
//        
//        assertEquals("Titles don't match", newTitle, firstCategoryTitleTd.getText()); 
//  
        
        
        
        private String getCategoryFromRow(WebElement row) {
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
        
        public String disableFirstCategory() {
            List<WebElement> rows = this.getAllRows();
            if (rows.size() == 0){
                return "";
            }
            WebElement firstRow = rows.get(0);
            String category = getCategoryFromRow(firstRow);
            
            this.clickOnDisableButton(firstRow);
            this.confirmDisable();
            return category;
        }
        
        public String enableFirstCategory() {
            List<WebElement> rows = this.getAllRows();
            if (rows.size() == 0){
                return "";
            }
            WebElement firstRow = rows.get(0);
            String category = getCategoryFromRow(firstRow);
            
            this.clickOnEnableButton(firstRow);
            this.confirmEnable();
            return category;
        }
        
            public String disableLastCategory() {
            List<WebElement> rows = this.getAllRows();
            if (rows.size() == 0){
                return "";
            }
            WebElement lastRow = rows.get(rows.size() - 1);
            String category = getCategoryFromRow(lastRow);
            
            this.clickOnDisableButton(lastRow);
            this.confirmDisable();
            return category;
        }
        
        public String enableLastCategory() {
            List<WebElement> rows = this.getAllRows();
            if (rows.size() == 0){
                return "";
            }
            WebElement lastRow = rows.get(rows.size() - 1);
            String category = getCategoryFromRow(lastRow);
            
            this.clickOnEnableButton(lastRow);
            this.confirmEnable();
            return category;
        }
        
        public String disableRandomCategory() {
            List<WebElement> rows = this.getAllRows();
            if (rows.size() == 0){
                return "";
            }
           WebElement randomRow = rows.get(Helper.getRandomInteger2(rows.size() - 1));
            String category = getCategoryFromRow(randomRow);
            
            this.clickOnDisableButton(randomRow);
            this.confirmDisable();
            return category;
        }
        
        public String deleteFirstCategory() {
            List<WebElement> rows = this.getAllRows();
            if (rows.size() == 0){
                return "";
            }
            WebElement firstRow = rows.get(0);
            String category = getCategoryFromRow(firstRow);
           
            this.clickOnDeleteButton(firstRow);
            this.confirmDelete();
            return category;
        }
        
        public String deleteLastCategory() {
            List<WebElement> rows = this.getAllRows();
            if (rows.size() == 0){
                return "";
            }
            WebElement lastRow = rows.get(rows.size() - 1);
            
            String category = getCategoryFromRow(lastRow);
            this.clickOnDeleteButton(lastRow);
            this.confirmDelete();
            return category;
        }
         
        public String deleteRandomCategory() {
            List<WebElement> rows = this.getAllRows();
            if (rows.size() == 0){
                return "";
            }
            WebElement randomRow = rows.get(Helper.getRandomInteger2(rows.size() - 1));
            
            String category = getCategoryFromRow(randomRow);
            this.clickOnDeleteButton(randomRow);
            this.confirmDelete();
            return category;
        }
 
}
    

