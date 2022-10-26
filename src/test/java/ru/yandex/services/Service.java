package ru.yandex.services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Service {
    private WebElement element;
//    private final ChromeDriver driver;
    private final FirefoxDriver driver;
    public Service(FirefoxDriver driver) {
        this.driver = driver;
    }
    //метод переходит на сайт
    public void InInput() {

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //метод скролит до выбранного элемента
    public void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //метод делает клик по выбранному элементу
    public void click(WebElement element) {
                element.click();
    }
    // метод производит ожидание появления выбранного элемента
    public void waitPageElement(By element) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //метод заполняет поля данными

    public void inputText (WebElement element, String text) {
               element.sendKeys(text);
        }

    }