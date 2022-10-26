package ru.yandex.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

// веб драйвер для mozila
public class Drivers {

        private static WebDriver driver;

        private static WebDriver init() {
            File driverPath = new File("");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setHeadless(true);
                    System.setProperty("webdriver.gecko.driver", driverPath.getAbsolutePath() + "C:\\chromedriver\\geckodriver.exe");
                    driver = new FirefoxDriver(firefoxOptions);
                    return driver;
            }
}