package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before()
    public void beforeTest(){
        DriverFactory.initializeDriver();
    }
    @After()
    public void afterTest(){
        DriverFactory.quitDriver();
    }
}
