package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;


public class MainPageSteps extends BaseSteps {



    @Step("выбран пункт меню {0}")
    public void selectMenuItem(String menuItem){
        new MainPage(driver).selectMenuItem(menuItem);
    }

    @Step("выбран пункт меню {0}")
    public void selectMenuInsurance(String menuItem){
        new MainPage(driver).selectInsuranceItem(menuItem);
    }

}
