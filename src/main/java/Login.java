import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    WebDriver driver;
    public Login(WebDriver driver){
        this.driver=driver;
    }
    public WebElement usernameEle(){
        By username = By.id("username");
        WebElement user = driver.findElement(username);

        return user;
    }
    public WebElement passEle(WebDriver driver){

    return driver.findElement(By.name("password"));
    }
    public By flash(){
        return By.id("flash");
    }
    public WebElement logout(WebDriver driver){
   return driver.findElement(By.cssSelector("a[href=\"/logout\"]"));
}
    public void loginSteps (String username, String pass){
        usernameEle().clear();
        usernameEle().sendKeys(username);
        passEle(driver).sendKeys(pass);
        passEle(driver).sendKeys(Keys.ENTER);
    }

}
