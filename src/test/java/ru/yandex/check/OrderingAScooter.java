package ru.yandex.check;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.page.HomePageScooter;
import ru.yandex.page.OrderPageScooter;
import ru.yandex.page.Profile;
import ru.yandex.services.Service;

import javax.swing.*;


public class OrderingAScooter {

    public ChromeDriver driver;
    public Service objService;
    public OrderPageScooter objOrderPageScooter;
    public HomePageScooter objHomePage;

    public Profile objProfile;

    @Before
    public void setUpOrder() {
        driver = new ChromeDriver();
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

            objProfile.profileData(name, surname, address, phoneNumber, station);

//            objService.inputText(objOrderPageScooter.getAddress(), address);
    }


    @After
    public void teardown() {
        System.out.println("test close");
      //  driver.quit();
    }
    }










