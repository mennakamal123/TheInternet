import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpenBrowserSoft

{

    WebDriver driver= null;
  @BeforeTest
 public void OpenBroweser() throws InterruptedException {
      driver= new ChromeDriver();
      driver.navigate().to("https://the-internet.herokuapp.com/login");
      driver.manage().window().maximize();
      Thread.sleep(3000);
  }
    @Test
    public void ValidData() {
    int count= driver.findElements(By.tagName("a")).size();
        System.out.println(count);
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        String ActualResult = driver.findElement(By.id("flash")).getText();
        String ExpectedResult = "You logged into a secure area!";
        SoftAssert soft = new SoftAssert();
        //first assert
        soft.assertTrue(ActualResult.contains(ExpectedResult),"first assert");
        //second
      soft.assertTrue(driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed(),"second");
         //third
      soft.assertEquals( driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure","third" );
      soft.assertAll();
    }


    @Test
    public void InValidData() {
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPasswor");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        String ActualResult = driver.findElement(By.id("flash")).getText();
        String ExpectedResult = "Your username is invalid!";
        Assert.assertTrue(ActualResult.contains(ExpectedResult),"text is wrong");

    }



    @AfterTest
    public void CloseBroweser(){
      //  driver.quit();
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
