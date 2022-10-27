package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class OrderPageScooter {
    private final FirefoxDriver driver;

    private final By name = By.xpath("//input[@placeholder ='* Имя']");

    public WebElement getName() {
        return driver.findElement(name);
    }

    public WebElement setName(String nameq) {
        driver.findElement(name).sendKeys(nameq);
        return null;
    }

    public WebElement setSurname(String nameq) {
        driver.findElement(surname).sendKeys(nameq);
        return null;
    }

    public WebElement getSurname() {
        return driver.findElement(surname);
    }

    public WebElement getAddress() {
        return driver.findElement(address);
    }

    public WebElement getPhoneNumber() {
        return driver.findElement(phoneNumber);
    }

    private final By surname = By.xpath("//input[@placeholder ='* Фамилия']");
    private final By address = By.xpath("//input[@placeholder ='* Адрес: куда привезти заказ']");


    public WebElement getStation() {
        return driver.findElement(station);
    }

    private final By station = By.xpath("//input[@placeholder ='* Станция метро']");
    public  final By station_CHERKIZOVSKAYA = By.xpath(".//li[@data-index='1']");
    private final By phoneNumber = By.xpath("//input[@placeholder ='* Телефон: на него позвонит курьер']");

    public WebElement getCalendar() {
        return driver.findElement(calendar);
    }

    private final By calendar = By.xpath("//input[@placeholder ='* Когда привезти самокат']");

    public WebElement getDate() {
        return driver.findElement(date);
    }

    private final By date = By.xpath("//div[@aria-label='Choose воскресенье, 6-е ноября 2022 г.']");

    public WebElement getLeaseTime() {
        return driver.findElement(leaseTime);
    }

    private final By leaseTime = By.className("Dropdown-placeholder");

    public WebElement getRentalTimeOneDay() {
        return driver.findElement(RentalTimeOneDay);
    }

    //    public List<WebElement> getListRentalTime() {
//        return driver.findElements(listRentalTime);
//    }
    private final By RentalTimeOneDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    private final By listRentalTime = By.className("Dropdown-option");

    public WebElement getBlackScooter() {
        return driver.findElement(blackScooter);
    }

    private final By blackScooter = By.id("black");
    private final By greyScooter = By.id("grey");

    public WebElement getComment() {
        return driver.findElement(comment);
    }

    private final By comment = By.xpath("//input[@placeholder ='Комментарий для курьера']");

    public WebElement getNext() {
        return driver.findElement(next);
    }

    private final By next = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final By back = By.className("Order_Buttons__1xGrp");

    public WebElement getOrder() {
        return driver.findElement(order);
    }

    private final By order = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[contains(text(), 'Заказать')]");

    public WebElement getPlaceAnOrderYes() {
        return driver.findElement(placeAnOrderYes);
    }

    private final By placeAnOrderYes = By.xpath("//button[contains(text(), 'Да')]");

    public WebElement getOrderPlaced() {
        return driver.findElement(orderPlaced);
    }

    private final By orderPlaced = By.xpath("//div[(text()= 'Заказ оформлен')]");

    public WebElement getLookStatus() {
        return driver.findElement(lookStatus);
    }

    private final By lookStatus = By.xpath("//button[contains(text(), 'Посмотреть статус')]");
    private final By orderWaitingPage = By.xpath("//div[contains(text(), 'Самокат на складе')]");
    private final By placeAnOrderNo = By.xpath("//button[contains(text(), 'Нет')]");
    private final By status = By.xpath("//button[contains(text(), 'Нет')]");



    // Проверка что заказ состоялся
    private final By listLookOrder = By.xpath("//div[@class='Track_Value__15eEX']");

   public List<WebElement> getListLookOrder() {
       return driver.findElements(listLookOrder);
   }


    public OrderPageScooter(FirefoxDriver driver) { this.driver = driver; }



}
