// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;


public class CelciusToFahrenheitTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void celciusToFahrenheitTest() {
    driver.get("http://localhost:8080/TemperatureConverter/");
    driver.manage().window().setSize(new Dimension(960, 821));
    driver.findElement(By.id("value")).click();
    driver.findElement(By.id("value")).click();
    driver.findElement(By.id("value")).sendKeys("100");
    driver.findElement(By.id("temperature")).click();
    driver.findElement(By.cssSelector("html")).click();
    driver.findElement(By.cssSelector("input:nth-child(6)")).click();
    driver.findElement(By.cssSelector("h1")).click();
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Your temperature in Fahrenheit is 212"));
  }
}
