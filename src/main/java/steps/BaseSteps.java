package steps;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import util.TestProperties;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();


  /*  @BeforeClass
    public static void setUp() throws Exception {
        switch (properties.getProperty("browser")){
           case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }*/

    @BeforeClass
    public static void startScenario(){
      /*  System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();*/
     System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
       driver = new FirefoxDriver();
        driver .get("http://www.sberbank.ru/ru/person");
        driver .manage().window().maximize();
        driver .manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver .manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

   // @AfterClass
    //public static void tearDown() throws Exception {
     //   driver.quit();
   // }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    protected void checkFillField(String value, By locator) {
        assertEquals(value, driver.findElement(locator).getAttribute("value"));
    }
    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}

