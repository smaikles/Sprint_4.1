
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;


public class Main {

    public static void main(String[] args) {
        File driverPath = new File("");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(false);
//        System.setProperty("webdriver.gecko.driver", "C:/YandexPracticum/qa-scooter/geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", driverPath.getAbsolutePath() + "/src/main/resources/drivers/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
//        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
}
