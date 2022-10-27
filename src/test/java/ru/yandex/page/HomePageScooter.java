package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HomePageScooter {
    private final FirefoxDriver driver;
    public WebElement getOrdered() { return driver.findElement(ordered); }

    // Локаторы для проверки первого сценария
    private final By cookie = By.id("rcc-confirm-button");
    private final By title = By.className("Header_LogoScooter__3lsAR");
    private final By img = By.xpath("//img[@alt='Scooter blueprint']");
    private final By modQuest = By.xpath("//div[text() = 'Вопросы о важном']");
    private final By ordered = By.xpath("//button[contains(text(), 'Заказать')]");

    // Преобразование локаторов в вебэлементы
    public By getTitle() { return title; }
    public By getImg() {
        return img;
    }
    public WebElement getCookie() {
        return driver.findElement(cookie);
    }
    public WebElement getmodQuest() {
        return driver.findElement(modQuest);
    }
    public HomePageScooter(FirefoxDriver driver) {
        this.driver = driver;
    }

}