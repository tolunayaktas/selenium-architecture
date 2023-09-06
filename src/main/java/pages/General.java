package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class General {
    ElementHelper helper;
    By CookiePolicy = By.cssSelector("privacy-bar__inner");
    By btn_Decline = By.cssSelector("button button--sm button--subdued");

    public General(WebDriver driver){
        this.helper = new ElementHelper(driver);
    }

    public void checkCookiePopUp(){
        helper.click1stIf2ndExists(CookiePolicy,btn_Decline);
    }

}
