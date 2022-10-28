package services;

import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import pageobject.OrderPage;

// Класс содержит методы для заполнение данных по заказу
public class Profile {

    public OrderPage objOrderPage;
    public FirefoxDriver driver;
    public Service objService;

    public Profile(FirefoxDriver driver) {
        this.driver = driver;
    }

    // Метод заполнения профиля клиента
    public Profile profileData(String name, String surname, String address, String phoneNumber, String station) {
        objOrderPage = new OrderPage(driver);
        objService = new Service(driver);

        objService.waitPageElement(objOrderPage.getTitleOrder());
        objOrderPage.getName().sendKeys(name);
        objOrderPage.getSurname().sendKeys(surname);
        objOrderPage.getAddress().sendKeys(address);
        objOrderPage.getPhoneNumber().sendKeys(phoneNumber);
        new Actions(driver).moveToElement(objOrderPage.getStation()).click().sendKeys(station)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        return this;
    }

    // Метод заполнения данных по заказу
    public Profile Orderrer() {
        objOrderPage = new OrderPage(driver);
        objService = new Service(driver);

        objService.waitPageElement(objOrderPage.getTitleRent());
        objOrderPage.getCalendar().click();
        objOrderPage.getDate().click();
        objOrderPage.getLeaseTime().click();
        objOrderPage.getRentalTimeOneDay().click();

        return this;
    }
}