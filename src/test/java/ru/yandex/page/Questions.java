package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Questions {
    private final ChromeDriver driver;
    private final By listQuestions = By.xpath("//*[@class='accordion__button']");
    private final By listAnswer = By.xpath("//div[@data-accordion-component='AccordionItemPanel']");

    public List<WebElement> getListQuestions() {
        return  driver.findElements(listQuestions);
    }

    public List<WebElement> getListAnswer() {
        return  driver.findElements(listAnswer);
    }

    public Questions(ChromeDriver driver) {
        this.driver = driver;
    }

}
