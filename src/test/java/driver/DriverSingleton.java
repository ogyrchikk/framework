package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
                driver = new ChromeDriver();


            driver.manage().window().maximize();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
        }
        return driver;
    }



    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}