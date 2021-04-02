
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static org.junit.Assert.assertEquals;

public class SendAppPage extends BasePage {


    @FindBy(id = "person_lastName")
    WebElement lastName;

    @FindBy(id = "person_firstName")
    WebElement firstName;

    @FindBy(id = "person_middleName")
    WebElement middleName;

    @FindBy(xpath = "//span[@class = 'checkbox']")
    WebElement noMiddleName;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "documentIssue")
    WebElement documentIssue;

    @FindBy(id = "name_vzr_ins_0")
    WebElement nameIns;

    @FindBy(id = "surname_vzr_ins_0")
    WebElement surnameIns;



    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDateIns;

    @FindBy(id = "person_birthDate")
    WebElement birthDate;

    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy(xpath = "//label[contains(text(), 'Женский')]")
    WebElement sexWoman;

    @FindBy(xpath = "//label[contains(text(), 'Мужской')]")
    WebElement sexMan ;


    @FindBy(xpath = "//*[contains(text(), 'Продолжить')]")
    public WebElement sendButton;

    public WebElement getSendButton() {
        return sendButton;
    }


    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия застрахованного":
                fillField(surnameIns, value);
                break;
            case  "Имя":
                fillField(nameIns, value);
                break;
            case  "Имя страхователя":
                fillField(firstName, value);
                break;
            case  "Дата рождения застрахованного":
                fillField(birthDateIns, value);
                break;
            case  "Отчество страхователя":
                fillField(middleName, value);
                break;

          // case  "Отчество отсутствует":
           //     driver.findElement(By.xpath("//span[@class = 'checkbox']")).click();
            //   break;
            case  "Дата рождения страхователя":
                fillField(birthDate, value);
                break;
            //case  "Пол":
               // driver.findElement(By.xpath("//label[contains(text(), 'Женский')]")).click();
               // break;
            case  "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case  "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case  "Когда выдан":
                fillField(documentDate, value);
                break;
            case  "Фамилия страхователя":
                fillField(lastName, value);
                break;
            case  "Кем выдан":
                fillField(documentIssue, value);
                break;


            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Фамилия застрахованного":
                return surnameIns.getAttribute("value");
            case  "Имя":
                return nameIns.getAttribute("value");
            case  "Дата рождения застрахованного":
                return birthDateIns.getAttribute("value");

            case  "Имя страхователя":
                return firstName.getAttribute("value");

            case  "Дата рождения страхователя":
                return birthDate.getAttribute("value");
            case  "Отчество страхователя":
                return middleName.getAttribute("value");
           // case  "Пол":
            //    return sexWoman.getAttribute("class");
            case  "Серия паспорта":
                return passportSeries.getAttribute("value");
            case  "Номер паспорта":
                return passportNumber.getAttribute("value");
            case  "Фамилия страхователя":
                return lastName.getAttribute("value");
            case  "Когда выдан":
                return documentDate.getAttribute("value");
            case  "Кем выдан":
                return documentIssue.getAttribute("value");

        }
        throw new AssertionError("Поле не объявлено на странице");
    }


    public void checkFieldErrorMessage(String field, String errorMessage){
        if (field.equals("Мобильный телефон") || field.equals("Электронная почта")||field.equals( "Повтор электронной почты")) {
            String xpath = "//*[contains(@title, '" + field + "')]//*[contains(text(), 'Поле не заполнено')]";
            //*[contains(@title, 'Мобильный телефон')]//*[contains(text(), 'Поле не заполнено')]
            String actualValue = driver.findElement(By.xpath(xpath)).getText();
           // Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                //    actualValue.contains(errorMessage));
            assertEquals(errorMessage, actualValue);
        } else {
            String xpath = "//*[@class='alert-form alert-form-error']";
            String actualValue = driver.findElement(By.xpath(xpath)).getText();
            assertEquals(errorMessage, actualValue);
        }

    }
}
