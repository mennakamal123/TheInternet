import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowser

{
    WebDriver driver= null;
    Login login ;
  @BeforeTest
 public void OpenBroweser() throws InterruptedException {
      driver= new ChromeDriver();
      driver.navigate().to("https://the-internet.herokuapp.com/login");
      driver.manage().window().maximize();
      Thread.sleep(3000);
      login = new Login(driver);

 }

    @Test
    public void ValidData() {

        driver.navigate().to("https://the-internet.herokuapp.com/login");
       login.loginSteps("tomsmith", "SuperSecretPassword!");

        String ActualResult = driver.findElement(login.flash()).getText();
        String ExpectedResult = "You logged into a secure area!";
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
      Assert.assertTrue(login.logout(driver).isDisplayed());
      Assert.assertEquals( driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure" );
    }


    @Test
    public void InValidData() {
        driver.navigate().to("https://the-internet.herokuapp.com/login");
       login.usernameEle().clear();
        login.usernameEle().sendKeys("tomsith");
       login.passEle(driver).sendKeys("SuperSecretPasswor");
       login.passEle(driver).sendKeys(Keys.ENTER);
        String ActualResult = driver.findElement(By.id("flash")).getText();
        String ExpectedResult = "Your username is invalid!";
        Assert.assertTrue(ActualResult.contains(ExpectedResult),"text is wrong");

    }



    @AfterTest
    public void CloseBroweser(){
        driver.quit();
    }
}
//   String msg= driver.findElement(By.id("flash")).getText();
//   System.out.println(msg);
// String attribute=  driver.findElement(By.id("flash")).getAttribute("class");
//   System.out.println(attribute);
// String cssColors=  driver.findElement(By.id("flash")).getCssValue("background-color");
// System.out.println(cssColors);

// driver.findElement(By.className("radius")).click();
// driver.findElement(By.linkText("Elemental  )).click();
//calling by parent
//  driver.findElement(By.cssSelector("form > button[type=\"submit\"]")).click();
// driver.findElement(By.xpath("//form[@id=\"login\"]//button[@type=\"submit\"]")).click();


