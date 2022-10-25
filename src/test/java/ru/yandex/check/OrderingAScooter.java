package ru.yandex.check;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.page.HomePageScooter;
import ru.yandex.page.OrderPageScooter;
import ru.yandex.page.Questions;
import ru.yandex.services.Service;

public class OrderingAScooter {

    public ChromeDriver driver;
    public Service objService;
    public OrderPageScooter objOrderPageScooter;
    public HomePageScooter objHomePage;

    @Before
    public void setUpOrder() {
        driver = new ChromeDriver();
        objService = new Service(driver);
        objOrderPageScooter = new OrderPageScooter(driver);
        objHomePage = new HomePageScooter(driver);

        objService.InInput();
        objService.click(objHomePage.getCookie());
        objService.click(objHomePage.getOrdered());
        objService.InInput();
        objService.click(objHomePage.getOrdered());
        System.out.println("test start");
    }
        @Test
        public void test_N11() {

            String name = "Михаил";
            String surname = "Михаил";

         objService.inputText(objOrderPageScooter.setName(name));
         objService.inputText(objOrderPageScooter.setSurname(surname));

    }


    @After
    public void teardown() {
        System.out.println("test close");
      //  driver.quit();
    }
    }










