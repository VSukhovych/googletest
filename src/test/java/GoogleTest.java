import base.DriverRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class GoogleTest {

    public WebDriver driver;

//    @BeforeClass(alwaysRun = true)
//    @Parameters({"os", "browser", "url", "node"})
//    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
//        DriverRepository setupTestDriver = new DriverRepository(os, browser, url, node);
//        driver = setupTestDriver.getDriver();
//    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new DriverRepository().getDriver();
    }

    @Test
    public void googleTitleTest() {
        // validate page title test
        Assert.assertTrue(driver.getTitle().contentEquals("Google"));
    }

    @Test
    public void googleUrlTest() {
        // validate current url test
        driver.get("http://www.google.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("www.google.com"));
    }

    @Test
    public void googleSearchButtonTest() {
        // basic test to validate that search button is displayed, enabled and it's value
        driver.get("http://www.google.com");
        WebElement searchButtonElement = driver.findElement(By.xpath(".//*[@class='FPdoLc VlcLAe']//*[@class='gNO89b']"));
        Assert.assertTrue(searchButtonElement.isDisplayed());
        Assert.assertTrue(searchButtonElement.isEnabled());
        Assert.assertTrue(searchButtonElement.getAttribute("value").contains("Пошук Google"));
    }

    @Test
    public void googleFeelingLuckyButtonTest() {
        // basic test to validate that feeling lucky button is displayed, enabled and it's value
        driver.get("http://www.google.com");
        WebElement feelingLuckyElement = driver.findElement(By.xpath(".//*[@class='FPdoLc VlcLAe']//*[@class='RNmpXc']"));
        Assert.assertTrue(feelingLuckyElement.isDisplayed());
        Assert.assertTrue(feelingLuckyElement.isEnabled());
        Assert.assertTrue(feelingLuckyElement.getAttribute("value").contains("Мені пощастить"));
    }

    @Test
    public void googleSearchBox() {
        // basic test to validate that search box displayed and enabled
        driver.get("http://www.google.com");
        WebElement searchElement = driver.findElement(By.name("q"));
        Assert.assertTrue(searchElement.isDisplayed());
        Assert.assertTrue(searchElement.isEnabled());
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}