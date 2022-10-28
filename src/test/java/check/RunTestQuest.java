package check;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.HomePage;
import services.Service;


import static org.junit.matchers.JUnitMatchers.containsString;

@RunWith(Parameterized.class)
public class RunTestQuest {

    public ChromeDriver driver;

    public HomePage objHomePage;
    public Service objService;

    private final String checkedText;
    private final int index;

    public RunTestQuest(String checkedText, int index) {
        this.checkedText = checkedText;
        this.index = index;


    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Оплата курьеру — наличными или картой.", 0},
                {"можете просто сделать несколько заказов — один за другим.", 1},
                {"Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Зарядка не понадобится.", 5},
                {"Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"И Москве, и Московской области.", 7},

        };
    }

    @Before
    public void setUp() {

        driver = new ChromeDriver();

        objService = new Service(driver);
        objHomePage = new HomePage(driver);
        System.out.println("test start");
         // запуск сайта
         objService.checkInQuest();



    }

    // коллекция тестов для проверки блока Вопросы о важном
    @Test
    public void test_n() {
        objService.click(objHomePage.getListQuestions().get(index));
        Assert.assertThat("Текс не совпадает с ОР: ", objHomePage.getListAnswer().get(index).getText(), containsString(checkedText));
    }

    @After
    public void teardown() {
        System.out.println("test close");
        driver.quit();
    }
}