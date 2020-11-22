
import org.junit.Test;
import pages.ChooseInsurancePage;
import pages.InsurancePage;
import pages.MainPage;
import pages.SendAppPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class TestInsurance extends BaseTest  {

    @Test
    public void testInsurance() throws Exception {
      driver.get(baseUrl);

        MainPage mainPage = new MainPage(driver);

        mainPage.selectMenuItem("Страхование");
        mainPage.selectInsuranceItem("Перейти в каталог");

        InsurancePage insurancePage = new InsurancePage(driver);

        insurancePage.waitSendAppClickable();
        insurancePage.selectInsuranceDirection("Путешествия");
        insurancePage.selectButtonInsurance("Оформить онлайн");

        ChooseInsurancePage chooseInsurancePage = new ChooseInsurancePage(driver);

        String actualTitle = chooseInsurancePage.title.getText();
        String expectedTitle = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
        chooseInsurancePage.selectButton("Оформить");

        SendAppPage sendAppPage = new SendAppPage(driver);

        sendAppPage.fillField("Серия паспорта", "0124");
        sendAppPage.fillField("Номер паспорта", "456789");
        sendAppPage.fillField("Кем выдан", "УВД района Зюзино г. Москва 125-154");
        sendAppPage.fillField("Фамилия страхователя", "Петрова");
        sendAppPage.fillField("Имя страхователя", "Анфиса");
        sendAppPage.fillField("Отчество страхователя", "Изольдовна");
        sendAppPage.fillField("Фамилия застрахованного", "Иванова");
        sendAppPage.fillField("Имя застрахованного", "Лиана");
        sendAppPage.fillField("Дата рождения застрахованного", "15.10.2000");
        sendAppPage.fillField("Дата рождения страхователя", "01.01.1992");
        sendAppPage.fillField("Пол", "Женский");
        sendAppPage.fillField("Когда выдан", "01.05.2018");

        assertEquals(sendAppPage.getFillField("Серия паспорта"), "0124");
        assertEquals(sendAppPage.getFillField("Номер паспорта"), "456789");
        assertEquals(sendAppPage.getFillField("Кем выдан"), "УВД района Зюзино г. Москва 125-154");
        assertEquals(sendAppPage.getFillField("Фамилия страхователя"), "Петрова");
        assertEquals(sendAppPage.getFillField("Имя страхователя"), "Анфиса");
        assertEquals(sendAppPage.getFillField("Отчество страхователя"), "Изольдовна");
        assertEquals(sendAppPage.getFillField("Имя застрахованного"), "Лиана");
        assertEquals(sendAppPage.getFillField("Дата рождения застрахованного"), "15.10.2000");
        assertEquals(sendAppPage.getFillField("Дата рождения страхователя"), "01.01.1992");
        assertEquals(sendAppPage.getFillField("Когда выдан"), "01.05.2018");
        assertEquals(sendAppPage.getFillField("Пол"), "btn ng-valid active ng-touched ng-dirty");

        sendAppPage.sendButton.click();

        sendAppPage.checkFieldErrorMessage("Мобильный телефон", "Поле не заполнено.");
        sendAppPage.checkFieldErrorMessage("Электронная почта", "Поле не заполнено.");
        sendAppPage.checkFieldErrorMessage("Повтор электронной почты", "Поле не заполнено.");
        sendAppPage.checkFieldErrorMessage("xp", "При заполнении данных произошла ошибка");

    }
}
