package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    static WebDriver driver;
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    private static String browser = PropertiesReader.getValue("browser");
    private static String url = PropertiesReader.getValue("url");
    private static int implicitlyWait = Integer.parseInt(PropertiesReader.getValue("implicitlyWait"));
    private static int pageLoadTimeout = Integer.parseInt(PropertiesReader.getValue("pageLoadTimeout"));


    public static void initializeDriver(){
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driverThread.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driverThread.set(new FirefoxDriver());
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driverThread.set(new SafariDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driverThread.set(new EdgeDriver());
                break;
            default:
                WebDriverManager.iedriver().setup();
                driverThread.set(new InternetExplorerDriver());
                break;
        }
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(implicitlyWait));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(pageLoadTimeout));
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().get(url);
    }
    public static WebDriver getDriver(){
        return driverThread.get();
    }
    public static void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }
    }

}
