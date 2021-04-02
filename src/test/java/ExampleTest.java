
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;


public class ExampleTest extends BaseSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    ChooseInsuranceSteps chooseInsuranceSteps = new ChooseInsuranceSteps();
    InsuranceSteps insuranceSteps = new InsuranceSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();

    HashMap<String, String> testData = new HashMap<>();


    @Title("Заявка на страховку для путешественников")
    @Test
    public void Test(){

        testData.put("Фамилия застрахованного","Макаров");
        testData.put("Дата рождения застрахованного","15.10.1990");
        testData.put("Имя страхователя","Артурчик");
        testData.put("Дата рождения страхователя","30.11.1988");
        //testData.put("Пол","Мужской");
        testData.put("Серия паспорта","0124");
        testData.put("Имя","London");
        testData.put("Номер паспорта","456789");

        testData.put("Когда выдан","01.05.2018");
        testData.put("Кем выдан","УВД района Зюзино г. Москва 125-154");


        testData.put("Отчество страхователя","Мамедович");
        testData.put("Фамилия страхователя","Араруев");
        System.out.println("Вывод списка" + testData);

        mainPageSteps.selectMenuItem("Страхование");
        mainPageSteps.selectMenuInsurance("Перейти в каталог");

        insuranceSteps.waitSendAppClickable();
        insuranceSteps.selectInsuranceDirection("Путешествия");
        insuranceSteps.selectButtonInsurance("Оформить онлайн");
        chooseInsuranceSteps.checkPageTitle("Страхование путешественников");
//        Wait<WebDriver> wait3 = new WebDriverWait(driver, 5, 1000);
//        wait3.until(ExpectedConditions.visibilityOf(
//                driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-large']"))));
//        System.out.println( "Доступность кнопки " + driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-large']")).isEnabled());
//        System.out.println( "Доступность кнопки2 " + driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-large']")).isDisplayed());
     chooseInsuranceSteps.selectButton("Оформить");
 // Wait<WebDriver> wait5 = new WebDriverWait(driver, 5, 1000);
   // wait5.until(ExpectedConditions.visibilityOf(
    //          driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-large']"))));

        System.out.println( "Доступность кнопки 3" + driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-large']")).isEnabled());
        System.out.println( "Доступность кнопки 4 " + driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-large']")).isDisplayed());
      // driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-large']")).click();
       driver.findElement(By.xpath("//button[text() ='Оформить']")).click();


        sendAppSteps.fillFields(testData);
        sendAppSteps.sendButton();
        sendAppSteps.checkErrorMessageField("Мобильный телефон", "Поле не заполнено.");
        sendAppSteps.checkErrorMessageField("Электронная почта", "Поле не заполнено.");
        sendAppSteps.checkErrorMessageField("Повтор электронной почты", "Пол не заполнено.");
        sendAppSteps.checkErrorMessageField("xp", "При заполнении данных произошла ошибка");

        sendAppSteps.checkFillFields(testData);


    }
}
