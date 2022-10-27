package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

// Класс содержит локаторы и вебэлементы главной странице
public class HomePage {
    private final FirefoxDriver driver;
    public HomePage(FirefoxDriver driver) {
        this.driver = driver;
    }

    // Локаторы на главной странице
    private final By cookie = By.id("rcc-confirm-button");
    private final By img = By.xpath("//img[@alt='Scooter blueprint']");
    private final By modQuest = By.xpath("//div[text() = 'Вопросы о важном']");
    private final By orderedTop = By.className("Button_Button__ra12g");
    private final By orderedDown = By.xpath("//button[contains(@class, 'Button_Middle')]");

    // Преобразование локаторов в вебэлементы
    public By getImg() {
        return img;
    }
    public WebElement getCookie() {
        return driver.findElement(cookie);
    }
    public WebElement getmodQuest() {
        return driver.findElement(modQuest);
    }
    public WebElement getOrderedTop() { return driver.findElement(orderedTop); }
    public WebElement getOrderedDown() { return driver.findElement(orderedDown); }

}