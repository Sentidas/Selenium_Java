package steps;

import pages.InsurancePage;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceSteps extends BaseSteps{

    @Step("закрыто сообщение от файлов cookie")
    public void waitSendAppClickable(){
        new InsurancePage(driver).waitSendAppClickable();
    }

    @Step("нажата кнопка {0}")
    public void selectInsuranceDirection(String menuItem){
        new InsurancePage(driver).selectInsuranceDirection("Путешествия");
    }

    @Step("нажата кнопка - {0}")
    public void selectButtonInsurance(String menuItem){
        new InsurancePage(driver).selectButtonInsurance("Оформить онлайн");
    }
}
