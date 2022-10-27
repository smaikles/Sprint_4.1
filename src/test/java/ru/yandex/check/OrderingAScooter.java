package ru.yandex.check;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

            objProfile.profileData("Антон", "Чехов", "119049, г Москва, ул Донская, д 8","89001002030" , "Сокол");
            objService.click(objOrderPageScooter.getNext());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            objProfile.Orderrer();
            objService.inputText(objOrderPageScooter.getComment(), "Hello World - test 1");
            objService.click((objOrderPageScooter.getOrder()));
            objService.click((objOrderPageScooter.getPlaceAnOrderYes()));

            Assert.assertTrue(objOrderPageScooter.getOrderPlaced().isDisplayed());

            objService.click((objOrderPageScooter.getLookStatus()));
            String good = "Антон";

//            System.out.println(objOrderPageScooter.getListLookOrder().get(1).getText());

            for (int i =0; i <9; i++) {
                System.out.println(objOrderPageScooter.getListLookOrder().get(i).getText());
            }
            Assert.assertEquals("Текс не совпадает с ОР: ", objOrderPageScooter.getListLookOrder().get(0).getText(), good);




//            objService.inputText(objOrderPageScooter.getAddress(), address);
    }


    @After
    public void teardown() {
        System.out.println("test close");
      //  driver.quit();
    }
    }










