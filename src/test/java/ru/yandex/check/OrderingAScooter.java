package ru.yandex.check;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

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
        objService.click(objHomePage.getOrdered());
        objService.InInput();
        objService.click(objHomePage.getOrdered());
        System.out.println("test start");
    }
        @Test
        public void test_N11() {

        String name = "Антон";
        String surname = "Чехов";
        String address = "119049, г Москва, ул Донская, д 8";
        String phoneNumber = "89001002030";
        String station = "Сокол";
        String comment = "Hello World - test 1";

            objProfile.profileData(name, surname, address, phoneNumber, station);
            objService.click(objOrderPageScooter.getNext());
            objProfile.Orderrer();
            objService.inputText(objOrderPageScooter.getComment(), comment);
            objService.click((objOrderPageScooter.getOrder()));

            objService.click((objOrderPageScooter.getPlaceAnOrderYes()));
            System.out.println("шаг проверки2");
             Assert.assertTrue(objOrderPageScooter.getOrderPlaced().getText().contains("Заказ оформлен"));
            System.out.println("шаг проверки3");

            //проверяем, что заказ оформлен
//            try {
 //             Assert.assertTrue(objOrderPageScooter.getOrderPlaced().isDisplayed());
//            } catch (NoSuchElementException e) {
//                Assert.fail("заказ не оформлен");
//            }

    }

    @After
    public void teardown() {
        System.out.println("test close");
      //  driver.quit();
    }
    }










