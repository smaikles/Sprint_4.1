package check;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import page.HomePage;
import services.Service;
import page.Questions;

import static org.hamcrest.CoreMatchers.endsWith;


public class RunTestQuest {

    public ChromeDriver driver;
    public Questions objQuestions;
    public HomePage objHomePage;
    public Service objService;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        objService = new Service(driver);
        objQuestions = new Questions(driver);
        objHomePage = new HomePage(driver);
        System.out.println("test start");

        objService.checkInQuest();

    }

    @Test
    public void test_N1() {
        objService.click(objQuestions.getListQuestions().get(0));
        String good = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals("Текс не совпадает с ОР: ", objQuestions.getListAnswer().get(0).getText(), good);
    }

    @Test
    public void test_N2() {

        objService.click(objQuestions.getListQuestions().get(1));
        String good = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals("Текс не совпадает с ОР: ", objQuestions.getListAnswer().get(1).getText(), good);
    }

    @Test
    public void test_N3() {

        objService.click(objQuestions.getListQuestions().get(2));
        //text = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String good = "9 мая в 20:30.";
        Assert.assertThat("Текс не совпадает с ОР: ", objQuestions.getListAnswer().get(2).getText(), endsWith(good));
    }

    @Test
    public void test_N4() {

        objService.click(objQuestions.getListQuestions().get(3));
        String good = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals("Текс не совпадает с ОР: ", objQuestions.getListAnswer().get(3).getText(), good);
    }

    @Test
    public void test_N5() {

        objService.click(objQuestions.getListQuestions().get(4));
        String good = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertEquals("Текс не совпадает с ОР: ", objQuestions.getListAnswer().get(4).getText(), good);
    }

    @Test
    public void test_N6() {

        objService.click(objQuestions.getListQuestions().get(5));
        //text = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String good = "Зарядка не понадобится.";
        Assert.assertThat("Текс не совпадает с ОР: ", objQuestions.getListAnswer().get(5).getText(), endsWith(good));
    }

    @Test
    public void test_N7() {

        objService.click(objQuestions.getListQuestions().get(6));
        String good = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertEquals("Текс не совпадает с ОР: ", objQuestions.getListAnswer().get(6).getText(), good);
    }

    @Test
    public void test_N8() {

        objService.click(objQuestions.getListQuestions().get(7));
        String good = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals("Текс не совпадает с ОР: ", objQuestions.getListAnswer().get(7).getText(), good);
    }

    @After
    public void teardown() {
        System.out.println("test close");
        driver.quit();
    }

}