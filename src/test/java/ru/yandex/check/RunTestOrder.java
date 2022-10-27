package ru.yandex.check;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import ru.yandex.page.HomePage;
import ru.yandex.page.OrderPage;
import ru.yandex.page.Profile;
import ru.yandex.services.Service;

@RunWith(Parameterized.class)
public class RunTestOrder {

    //   public ChromeDriver driver;
    public FirefoxDriver driver;
    // public FirefoxOptions ;
    public Service objService;
    public OrderPage objOrderPage;
    public HomePage objHomePage;
    public Profile objProfile;

    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String station;
    private final String comment;

    public RunTestOrder(String name, String surname, String address, String phoneNumber, String station,String comment){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.station = station;
        this.comment = comment;
    }


    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                {"Антон", "Чехов", "119049, г Москва, ул Донская, д 8", "89001002030", "Сокол", "тесте № 1"},
                {"Александр", "Пушкин", "101000, г Москва, ул Пушкина, д Колотушкина","+79991002039", "Лубянка", "тесте № 2"}
        };
    }
    @Before
    public void setUpOrder() {
        //  driver = new ChromeDriver();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(false);
        System.setProperty("webdriver.gecko.driver", "C:/YandexPracticum/qa-scooter/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);

        objService = new Service(driver);
        objOrderPage = new OrderPage(driver);
        objHomePage = new HomePage(driver);
        objProfile = new Profile(driver);

        System.out.println("test start");
    }

    @Test
    public void test_N1() {
        objService.orderInTop();
        objProfile.profileData(name, surname, address, phoneNumber, station);
        objService.click(objOrderPage.getNext());
        objProfile.Orderrer();
        objService.click(objOrderPage.getBlackScooter())
                .inputText(objOrderPage.getComment(),comment)
                .click((objOrderPage.getOrder()))
                .click((objOrderPage.getPlaceAnOrderYes()));

        assertTrue("Отсутствует сообщение об успешном завершении заказа",
                objService.isElementPresent(objOrderPage.orderPlaced));

    }

  //  @Test
    public void test_N2() {
        objService.orderInDown();
        objProfile.profileData("Александр", "Пушкин",
                "101000, г Москва, ул Пушкина, д Колотушкина","+79991002039", "Лубянка");
        objService.click(objOrderPage.getNext());
        objProfile.Orderrer();
        objService.click(objOrderPage.getGreyScooter())
                .inputText(objOrderPage.getComment(), " в тесте № 2")
                .click((objOrderPage.getOrder()))
                .click((objOrderPage.getPlaceAnOrderYes()));

        assertTrue("Отсутствует сообщение об успешном завершении заказа",
                objService.isElementPresent(objOrderPage.orderPlaced));

    }

    @After
    public void teardown() {
        System.out.println("test close");
//          driver.quit();

    }
}










