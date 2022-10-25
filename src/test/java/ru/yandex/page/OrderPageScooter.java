package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OrderPageScooter {
    private final ChromeDriver driver;

    private final By name = By.xpath("//input[@placeholder ='* Имя']");
    private final By surname = By.xpath("//input[@placeholder ='* Фамилия']");
    private final By address = By.xpath("//input[@placeholder ='* Адрес: куда привезти заказ']");
    private final By station = By.xpath("//input[@placeholder ='* Станция метро']");
    private final By phoneNumber = By.xpath("//input[@placeholder ='* Телефон: на него позвонит курьер']");


    private final By calendar = By.xpath("//input[@placeholder ='* Когда привезти самокат']");
    private final By leaseTime = By.className("Dropdown-placeholder");

    public List<WebElement> getListRentalTime() {
        return driver.findElements(listRentalTime);
    }

    private final By listRentalTime = By.className("Dropdown-option");
    ////*[@class='Dropdown-option']
    private final By blackScooter = By.id("black");
    private final By greyScooter = By.id("grey");
    private final By comment = By.xpath("//input[@placeholder ='Комментарий для курьера']");


    private final By next = By.className("Order_NextButton__1_rCA");
    private final By back = By.className("Order_Buttons__1xGrp");
    private final By order = By.className("Button_Button__ra12g Button_Middle__1CSJM");


    private final By placeAnOrderYes = By.xpath("//button[contains(text(), 'Да')]");
    private final By placeAnOrderNo = By.xpath("//button[contains(text(), 'Нет')]");
    private final By status = By.xpath("//button[contains(text(), 'Нет')]");

    public OrderPageScooter(ChromeDriver driver) { this.driver = driver; }
}
