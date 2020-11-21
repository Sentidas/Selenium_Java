import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestInsurance{
    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//*[@aria-label='Меню  Страхование']")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Перейти в каталог')]")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        WebElement closeCookie = driver.findElement(By.xpath("//*[contains(text(), 'Закрыть')][contains(@class,'cookie')]"));
        wait.until(ExpectedConditions.visibilityOf(closeCookie)).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Путешествия')]")).click();
        assertEquals("Страхование для путешественников", driver.findElement(By.xpath("//div[@class = 'uc-form__wrapper-full uc-form__wrapper-full_no-grouping']/div[1]//h3[contains(text(), 'Страхование для путешественников')] ")).getText());
        driver.findElement(By.xpath("//div[@class = 'uc-form__wrapper-full uc-form__wrapper-full_no-grouping']/div[1]//*[contains(text(), 'Оформить онлайн')]")).click();

        WebElement title = driver.findElement(By.xpath("//h2[contains(text(), 'Страхование путешественников')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
        assertEquals("Страхование путешественников", title.getText());

        driver.findElement(By.xpath("//button[contains(text(), 'Оформить')]")).click();


        fillField(By.id("person_lastName"), "Иванова");
        fillField(By.id("person_firstName"), "Альфия");
        fillField(By.id("person_middleName"), "Александровна");
        fillField(By.id("passportSeries"), "1234");
        fillField(By.id("passportNumber"), "456789");
        fillField(By.id("documentIssue"), "УВД г. Москвы, р-н Зюзино 145-789");
        fillField(By.id("surname_vzr_ins_0"), "Грюнкина");
        fillField(By.id("name_vzr_ins_0"), "Анфиса");
        fillField(By.id("birthDate_vzr_ins_0"), "12.08.1961");
        fillField(By.id("person_middleName"), "Александровна");
        fillField(By.id("person_birthDate"), "11.12.1988");
        fillField(By.id("documentDate"), "01.12.2010");
        driver.findElement(By.xpath("//label[contains(text(), 'Женский')]")).click();

        assertEquals("Иванова", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Альфия", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Александровна", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("1234", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("УВД г. Москвы, р-н Зюзино 145-789", driver.findElement(By.id("documentIssue")).getAttribute("value"));
        assertEquals("Грюнкина", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        assertEquals("Анфиса", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        assertEquals("12.08.1961", driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        assertEquals("Александровна", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("11.12.1988", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("1234", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("456789", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("01.12.2010", driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("btn ng-valid active ng-touched ng-dirty", driver.findElement(By.xpath("//label[contains(text(), 'Женский')]")).getAttribute("class"));

        driver.findElement(By.xpath("//*[contains(text(), 'Продолжить')]")).click();

        assertEquals("Поле не заполнено.",
                driver.findElement(By.xpath("//*[contains(@title, 'Мобильный телефон')]//*[contains(text(), 'Поле не заполнено')]")).getText());
        assertEquals("Поле не заполнено.",
                driver.findElement(By.xpath("//*[contains(@title, 'Электронная почта')]//*[contains(text(), 'Поле не заполнено')]")).getText());
        assertEquals("Поле не заполнено.",
                driver.findElement(By.xpath("//*[contains(@title, 'Повтор электронной почты')]//*[contains(text(), 'Поле не заполнено')]")).getText());
        assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.xpath("//*[@class='alert-form alert-form-error']")).getText());
        assertEquals("Поле не заполнено.",
                driver.findElement(By.xpath("//span[contains(@class, 'phone')]//*[contains(text(), 'Поле не заполнено')]")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    private void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
}
