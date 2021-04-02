package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ChooseInsurancePage;
import pages.MainPage;
import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class ChooseInsuranceSteps extends BaseSteps{

    @Step("заголовок страницы -  равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new ChooseInsurancePage(driver).title.getText();
        String expectedTitle2 = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle2));
    }

    @Step("выбран пункт меню {0}")
    public void selectButton(String menuItem){
       /* Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//button[text()='Оформить']"))));*/
        new ChooseInsurancePage(driver).selectButton(menuItem);


    }

}