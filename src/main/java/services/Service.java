package services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.HomePage;

// Класс описывает большинство однообразных действий
public class Service {
    public HomePage objHomePage;
    private WebElement element;
    //    private final ChromeDriver driver;
    private final FirefoxDriver driver;

    public Service(FirefoxDriver driver) {
        this.driver = driver;
    }

    // Метод переходит на сайт
    public Service InInput() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }

    // Метод скролит до выбранного элемента
    public Service scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    // Метод делает скрол и клик по выбранного элемента
    public Service click(WebElement element) {
        scroll(element);
        element.click();
        return this;
    }

    // Метод производит ожидание появления выбранного элемента
    public Service waitPageElement(By element) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }

    // Метод заполняет поля данными
    public Service inputText(WebElement element, String text) {
        element.sendKeys(text);
        return this;
    }

    // Метод проверки присутсвия элемента
    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    // Метод перехода на сайт и скролинга к списку вопросов
    public Service checkInQuest() {
        objHomePage = new HomePage(driver);

        InInput();
        click(objHomePage.getCookie());
        waitPageElement(objHomePage.getImg());
        scroll(objHomePage.getmodQuest());
        return this;
    }

}