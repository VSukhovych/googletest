import base.DriverRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YahooTest {

    private WebDriver driver;

//    @BeforeClass(alwaysRun = true)
//    @Parameters({"os", "browser", "url", "node"})
//    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
//        DriverRepository setupTestDriver = new DriverRepository();
//        driver = setupTestDriver.getDriver();
//    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        DriverRepository setupTestDriver = new DriverRepository();
        driver = setupTestDriver.getDriver();
    }

    @Test
    public void yahooSearchButtonTest() {
        driver.get("https://www.yahoo.com/");
        WebElement searchButtonElement = driver.findElement(By.id("uh-search-button"));
        Assert.assertTrue(searchButtonElement.isDisplayed());
        Assert.assertTrue(searchButtonElement.isEnabled());
        WebElement searchInput = driver.findElement(By.id("uh-search-box"));
        searchInput.sendKeys("test");
        searchButtonElement.click();
        WebElement firstSearchResult = driver.findElement(By.xpath(".//*[@class='title']/*[contains(@href, 'http')]"));
        Assert.assertTrue(firstSearchResult.getText().toLowerCase().contains("test"), "Error - search resuly is incorrect");
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
