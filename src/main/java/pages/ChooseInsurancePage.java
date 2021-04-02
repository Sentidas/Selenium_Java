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
        Wait<WebDriver> wait4 = new WebDriverWait(driver, 5, 1000);
        wait4.until(ExpectedConditions.visibilityOf(
          driver.findElement(By.xpath("//button[contains(text(),'" + itemName + "')]"))));
      driver.findElement(By.xpath("//button[contains(text(), '" + itemName + "')]")).click();


     //   driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-large']"))));
      //  driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-large']")).click();
    }

    /*public void selectButton2(String itemName) {
        Wait<WebDriver> wait4 = new WebDriverWait(driver, 5, 1000);
        wait4.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-large']"))));
        driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-large']")).click();
        //driver.findElement(By.xpath("//button[text() ='" + itemName + "')]")).click();
    }*/
}
