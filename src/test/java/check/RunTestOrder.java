package check;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import pageobject.HomePage;
import pageobject.OrderPage;
import steps.Profile;
import services.Service;

@RunWith(Parameterized.class)
public class RunTestOrder {

       public ChromeDriver driver;


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
    private final String orderButton;

    public RunTestOrder(String name, String surname, String address, String phoneNumber, String station, String comment, String orderButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.station = station;
        this.comment = comment;
        this.orderButton = orderButton;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Антон", "Чехов", "119049, г Москва, ул Донская, д 18", "89001002030", "Сокол", "Комментарий в тесте № 1", "заказать внизу"},
                {"Александр", "Пушкин", "101000, г Москва, ул Пушкина, д 7", "+79991002039", "Лубянка", " Комментарий в тесте № 2", "заказать вверху"}
        };

    }

    @Before
    public void setUpOrder() {
          driver = new ChromeDriver();

        objService = new Service(driver);
        objOrderPage = new OrderPage(driver);
        objHomePage = new HomePage(driver);
        objProfile = new Profile(driver);

        System.out.println("test start");

        objService.InInput()
                .click(objHomePage.getCookie())
                .waitPageElement(objHomePage.getImg());
    }


    @Test // Создает заказ с нижней кнопки
    public void orderIn() {

        if(orderButton.equals("заказать внизу")){
            System.out.println("555555555");
            objService.click(objHomePage.getOrderedDown());
        } else {
            objService.click(objHomePage.getOrderedTop());
        }

        objProfile.profileData(name, surname, address, phoneNumber, station);
        objService.click(objOrderPage.getNext());
        objProfile.Orderrer();

        objService.click(objOrderPage.getGreyScooter())
                .inputText(objOrderPage.getComment(), comment)
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










