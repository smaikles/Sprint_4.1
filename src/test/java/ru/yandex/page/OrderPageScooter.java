package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class OrderPageScooter {
    private final FirefoxDriver driver;
    public OrderPageScooter(FirefoxDriver driver) { this.driver = driver; }


    // Локаторы для проверки второго сценария
    private final By name = By.xpath("//input[@placeholder ='* Имя']");
    private final By surname = By.xpath("//input[@placeholder ='* Фамилия']");
    private final By address = By.xpath("//input[@placeholder ='* Адрес: куда привезти заказ']");
    private final By station = By.xpath("//input[@placeholder ='* Станция метро']");
    private final By phoneNumber = By.xpath("//input[@placeholder ='* Телефон: на него позвонит курьер']");
    private final By calendar = By.xpath("//input[@placeholder ='* Когда привезти самокат']");
    private final By date = By.xpath("//div[contains(@class, 'day--today')]");
    private final By leaseTime = By.className("Dropdown-placeholder");
    private final By RentalTimeOneDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    private final By blackScooter = By.id("black");
    private final By greyScooter = By.id("grey");
    private final By comment = By.xpath("//input[@placeholder ='Комментарий для курьера']");
    private final By next = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final By order = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[contains(text(), 'Заказать')]");
    private final By placeAnOrderYes = By.xpath("//button[contains(text(), 'Да')]");
    public final By orderPlaced = By.xpath("//div[(text()= 'Заказ оформлен')]");
    private final By lookStatus = By.xpath("//button[contains(text(), 'Посмотреть статус')]");
    private final By orderWaitingPage = By.xpath("//div[contains(text(), 'Самокат на складе')]");
    private final By placeAnOrderNo = By.xpath("//button[contains(text(), 'Нет')]");
    private final By status = By.xpath("//button[contains(text(), 'Нет')]");

    // Проверка что заказ состоялся
    private final By listLookOrder = By.xpath("//div[@class='Track_Value__15eEX']");

    // Преобразование локаторов в вебэлементы
    public WebElement getName() { return driver.findElement(name); }
    public WebElement getSurname() { return driver.findElement(surname); }
    public WebElement getAddress() { return driver.findElement(address); }
    public WebElement getPhoneNumber() { return driver.findElement(phoneNumber); }
    public WebElement getStation() { return driver.findElement(station); }
    public WebElement getCalendar() { return driver.findElement(calendar); }
    public WebElement getDate() { return driver.findElement(date); }
    public WebElement getLeaseTime() { return driver.findElement(leaseTime); }
    public WebElement getRentalTimeOneDay() { return driver.findElement(RentalTimeOneDay); }
    public WebElement getBlackScooter() { return driver.findElement(blackScooter); }
    public WebElement getComment() { return driver.findElement(comment); }
    public WebElement getNext() { return driver.findElement(next); }
    public WebElement getOrder() { return driver.findElement(order); }
    public WebElement getPlaceAnOrderYes() { return driver.findElement(placeAnOrderYes); }
    public WebElement getOrderPlaced() { return driver.findElement(orderPlaced); }
    public WebElement getLookStatus() { return driver.findElement(lookStatus); }

}