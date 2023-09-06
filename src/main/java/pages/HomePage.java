package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class HomePage {
    ElementHelper helper;
    By btn_AboutCoffee = By.cssSelector("summary.text-with-icon.link-faded-reverse[data-url='/pages/our-process']");
    By lst_Navbar = By.cssSelector(".dropdown-menu.dropdown-menu--restrictable span.reversed-link");
    By btn_Search = By.cssSelector(".header__icon-list .hidden.tap-area:nth-child(1)");
    By btn_Account = By.cssSelector(".header__icon-list .hidden.tap-area:nth-child(2)");
    By btn_Cart = By.cssSelector(".header__secondary-nav .header__icon-list>a:nth-child(3)");





    public HomePage(WebDriver driver){
        this.helper = new ElementHelper(driver);
    }
    public String getTitle(){
        return helper.getTitle();
    }
    public void checkAndClickAboutCoffee(){
        helper.checkElement(btn_AboutCoffee);
        helper.click(btn_AboutCoffee);
    }
    public void checkElementsBelowAboutCoffee(String birinci){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        helper.checkElementsWithText(lst_Navbar,birinci);
    }
    public void checkSecondNavbarsItems(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        helper.checkElement(btn_Search);
        helper.checkElement(btn_Account);
        helper.checkElement(btn_Cart);
    }
}
