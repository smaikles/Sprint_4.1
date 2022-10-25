package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomePageScooter {
    private final ChromeDriver driver;

//селекторы на главной странице
    private final By title = By.className("Header_LogoScooter__3lsAR");
    private final By img = By.xpath("//img[@alt='Scooter blueprint']");
    private final By cookie = By.id("rcc-confirm-button");
    private final By modQuest = By.xpath("//div[text() = 'Вопросы о важном']");
    private final By ordered = By.xpath("//button[contains(text(), 'Заказать')]");

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

    public HomePageScooter(ChromeDriver driver) {
        this.driver = driver;
    }

    public WebElement getOrdered() { return driver.findElement(ordered); }

}
