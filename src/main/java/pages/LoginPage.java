package pages;

import framework.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    
    private WebDriver driver;
    
    private final By emailFieldLocator = By.name("email");
    private final By passwordFieldLocator = By.name("password");
    private final By loginButtonLocator = By.className("btn-primary");
    private final By rememberMeCheckBoxLocator = By.name("remember");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver; 
    }
    
    private void setValidEmail() {
        driver.findElement(emailFieldLocator).sendKeys(Configuration.validEmail);
    }
    
    private void setValidPassword() {
        driver.findElement(passwordFieldLocator).sendKeys(Configuration.validPassword);
    }
    
    private void setEmail(String email) {
        driver.findElement(emailFieldLocator).sendKeys(email);
    }
    
    private void setPassword(String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    
    private void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }
    
    public void clickRememberMe() {
        driver.findElement(rememberMeCheckBoxLocator).click();
    }
    
    
    public void login() {
        setValidEmail();
        setValidPassword();
        clickLoginButton();
    }
    
    public void loginWithRememberMe() {
        setValidEmail();
        setValidPassword();
        clickRememberMe();
        clickLoginButton();

    }
    
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
        
    }
    
   
    
    
    
    
     /* //Login start
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(Configuration.validEmail);
        
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(Configuration.validPassword);
        
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();
        //Login end
    */    

    
    
}
