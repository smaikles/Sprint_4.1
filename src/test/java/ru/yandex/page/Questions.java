package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

//селекторы в блоке с вопросами "Вопросы о важном"
public class Questions {
    private final FirefoxDriver driver;
    public Questions(FirefoxDriver driver) { this.driver = driver; }

    // Локаторы для проверки первого сценария список вопросов и ответов
    private final By listQuestions = By.xpath("//*[@class='accordion__button']");
    private final By listAnswer = By.xpath("//div[@data-accordion-component='AccordionItemPanel']");

    // создаю коллекцию из элементов вопросов
    public List<WebElement> getListQuestions() { return driver.findElements(listQuestions); }

    // создаю коллекцию из элементов ответов
    public List<WebElement> getListAnswer() { return driver.findElements(listAnswer); }

}