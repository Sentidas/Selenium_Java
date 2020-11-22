package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseInsurancePage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Страхование путешественников')]")
    public WebElement title;


    public ChooseInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void selectButton(String itemName) {
        driver.findElement(By.xpath("//*[contains(text(),'" + itemName + "')]")).click();
    }
}
