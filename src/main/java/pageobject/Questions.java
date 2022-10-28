//package pageobject;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.util.List;
//
//// Класс содержит локаторы в блоке с вопросами "Вопросы о важном"
//public class Questions {
//    private final FirefoxDriver driver;
//    public Questions(FirefoxDriver driver) { this.driver = driver; }
//
//    // Локаторы из списка вопросов и ответов
//    private final By listQuestions = By.xpath("//*[@class='accordion__button']"); // элемент вопросов
//    private final By listAnswer = By.xpath("//div[@data-accordion-component='AccordionItemPanel']"); // элемент ответов
//
//    // Коллекция из элементов вопросов
//    public List<WebElement> getListQuestions() { return driver.findElements(listQuestions); }
//
//    // Коллекция из элементов ответов
//    public List<WebElement> getListAnswer() { return driver.findElements(listAnswer); }
//
//}