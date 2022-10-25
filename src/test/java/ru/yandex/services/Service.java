package ru.yandex.services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Service {
    private final ChromeDriver driver;

    public Service(ChromeDriver driver) {
        this.driver = driver;
    }

    public void InInput() {

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void click(WebElement element) {
                element.click();
    }

    public void waitPageElement(By element) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
