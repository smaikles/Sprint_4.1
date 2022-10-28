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
    private final int num;


    public RunTestQuest(String checkedText, int num) {
        this.checkedText = checkedText;
        this.num = num;
            }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"или картой.",0},
                {"один за другим.",1},
                {"9 мая в 20:30.",2},
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
        objService.click(objHomePage.getListQuestions().get(num));
        Assert.assertThat("Текс не совпадает с ОР: ", objHomePage.getListAnswer().get(num).getText(), containsString(checkedText));
    }
/*
    @Test
    public void test_n2() {

        objService.click(objHomePage.getListQuestions().get(1));
        String good = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals("Текс не совпадает с ОР: ", objHomePage.getListAnswer().get(1).getText(), good);
    }

    @Test
    public void test_n3() {

        objService.click(objHomePage.getListQuestions().get(2));
        //text = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String good = "9 мая в 20:30.";
        Assert.assertThat("Текс не совпадает с ОР: ", objHomePage.getListAnswer().get(2).getText(), endsWith(good));
    }

    @Test
    public void test_n4() {

        objService.click(objHomePage.getListQuestions().get(3));
        String good = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals("Текс не совпадает с ОР: ", objHomePage.getListAnswer().get(3).getText(), good);
    }

    @Test
    public void test_n5() {

        objService.click(objHomePage.getListQuestions().get(4));
        String good = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertEquals("Текс не совпадает с ОР: ", objHomePage.getListAnswer().get(4).getText(), good);
    }

    @Test
    public void test_n6() {

        objService.click(objHomePage.getListQuestions().get(5));
        //text = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String good = "Зарядка не понадобится.";
        Assert.assertThat("Текс не совпадает с ОР: ", objHomePage.getListAnswer().get(5).getText(), endsWith(good));
    }

    @Test
    public void test_n7() {

        objService.click(objHomePage.getListQuestions().get(6));
        String good = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertEquals("Текс не совпадает с ОР: ", objHomePage.getListAnswer().get(6).getText(), good);
    }

    @Test
    public void test_n8() {

        objService.click(objHomePage.getListQuestions().get(7));
        String good = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals("Текс не совпадает с ОР: ", objHomePage.getListAnswer().get(7).getText(), good);
    }
*/
    @After
    public void teardown() {
        System.out.println("test close");
      //  driver.quit();
    }

}