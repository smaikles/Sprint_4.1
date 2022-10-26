package ru.yandex.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Profile {
    public HomePageScooter objHomePage;
    public OrderPageScooter objOrderPageScooter;
    public FirefoxDriver driver;

    public Profile profileData (String name, String surname, String address, String phoneNumber, String station){

        objOrderPageScooter = new OrderPageScooter(driver);

        objOrderPageScooter.getName().sendKeys(name);
        objOrderPageScooter.getSurname().sendKeys(surname);
        objOrderPageScooter.getAddress().sendKeys(address);
        objOrderPageScooter.getPhoneNumber().sendKeys(phoneNumber);

        new Actions(driver).moveToElement(objOrderPageScooter.getStation()).click().sendKeys(station)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();


        return this;
    }

    public Profile Orderrer () {
        objOrderPageScooter = new OrderPageScooter(driver);

        objOrderPageScooter.getCalendar().click();
        objOrderPageScooter.getDate().click();
        objOrderPageScooter.getLeaseTime().click();
        objOrderPageScooter.getRentalTimeOneDay().click();
        objOrderPageScooter.getBlackScooter().click();

       return this;


//        objService.click(objOrderPageScooter.getCalendar());
//        objService.click((objOrderPageScooter.getDate()));
//        objService.click((objOrderPageScooter.getLeaseTime()));
//        objService.click((objOrderPageScooter.getRentalTimeOneDay()));
//        objService.click(objOrderPageScooter.getBlackScooter());
//        objService.inputText(objOrderPageScooter.getComment(), comment);
//        objService.click((objOrderPageScooter.getOrder()));


    }
    public Profile (FirefoxDriver driver) { this.driver = driver; }

}
