package ru.yandex.check;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import ru.yandex.page.HomePageScooter;
import ru.yandex.page.OrderPageScooter;
import ru.yandex.page.Profile;
import ru.yandex.services.Service;


public class OrderingAScooter {

 //   public ChromeDriver driver;
    public FirefoxDriver driver;
   // public FirefoxOptions ;
    public Service objService;
    public OrderPageScooter objOrderPageScooter;
    public HomePageScooter objHomePage;
    public Profile objProfile;

    @Before
    public void setUpOrder() {
      //  driver = new ChromeDriver();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(false);
        System.setProperty("webdriver.gecko.driver", "C:/YandexPracticum/qa-scooter/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);

        objService = new Service(driver);
        objOrderPageScooter = new OrderPageScooter(driver);
        objHomePage = new HomePageScooter(driver);
        objProfile = new Profile(driver);

        objService.InInput();
        objService.click(objHomePage.getCookie());
 //       objService.click(objHomePage.getOrderedTop());

//        objService.InInput();
        objService.click(objHomePage.getOrderedDown());

        System.out.println("test start");
    }
   //  @Test
        public void test_N1() {

            objProfile.profileData("Антон", "Чехов", "119049, г Москва, ул Донская, д 8", "89001002030", "Сокол");
            objService.click(objOrderPageScooter.getNext());
            objProfile.Orderrer();
            objOrderPageScooter.getBlackScooter().click();
            objService.inputText(objOrderPageScooter.getComment(), "Hello World - test 1")
                       .click((objOrderPageScooter.getOrder()))
                       .click((objOrderPageScooter.getPlaceAnOrderYes()));

              assertTrue("Отсутствует сообщение об успешном завершении заказа",objService.isElementPresent(objOrderPageScooter.orderPlaced));

    }

        @Test
        public void test_N2() {

            objProfile.profileData("Александр", "Пушкин", "101000, г Москва, ул Пушкина, д Колотушкина",
                    "89991002039", "Лубянка");
            objService.click(objOrderPageScooter.getNext());
            objProfile.Orderrer();
            objOrderPageScooter.getGreyScooter().click();
            objService.inputText(objOrderPageScooter.getComment(), "Hello World - test 2")
                    .click((objOrderPageScooter.getOrder()))
                    .click((objOrderPageScooter.getPlaceAnOrderYes()));

            assertTrue("Отсутствует сообщение об успешном завершении заказа",objService.isElementPresent(objOrderPageScooter.orderPlaced));

    }
    @After
    public void teardown() {
        System.out.println("test close");
      //  driver.quit();
    }
}










