package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementHelper {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public ElementHelper(WebDriver driver){
        this.driver = driver;
        String time = PropertiesReader.getValue("webDriverWait");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(time)));
        this.actions = new Actions(driver);

    }
    public String getTitle(){
        return driver.getTitle();
    }
    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
    public void click(By locator){
        findElement(locator).click();
    }

    public void checkElement(By locator) {
        findElement(locator);
    }

    public void checkElementsWithText(By locator, String text) {
        int i = 0;
        boolean check = false;
        List<WebElement> elementList = findElements(locator);
        for (WebElement elem : elementList) {
            System.out.println(elem.getText());
            if (elem.getText().contains(text)) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check, "The value returned could not match all of the values in the list.");
    }
    public void click1stIf2ndExists(By firstElement, By secondElement){
        try {
            List<WebElement> firstElementList = findElements(firstElement);
            if (!firstElementList.isEmpty()) {
                click(secondElement);
            }
        } catch (Exception e) {
            // It does nothing when pop-up could not be found.
        }

    }


}
