package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import static ru.yandex.page.OrderPageScooter.*;

public class Profile {
    public HomePageScooter objHomePage;
    public OrderPageScooter objOrderPageScooter;
    public ChromeDriver driver;

    public Profile profileData (String name, String surname, String address, String phoneNumber, String station){

        objOrderPageScooter = new OrderPageScooter(driver);

        objOrderPageScooter.getName().sendKeys(name);
        objOrderPageScooter.getSurname().sendKeys(surname);
        objOrderPageScooter.getAddress().sendKeys(address);
        objOrderPageScooter.getPhoneNumber().sendKeys(phoneNumber);
       // objOrderPageScooter.getStationLi().click();
        new Actions(driver).moveToElement(objOrderPageScooter.getStationLi()).click().sendKeys(station)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();


        return this;
    }
    public Profile (ChromeDriver driver) { this.driver = driver; }

}
