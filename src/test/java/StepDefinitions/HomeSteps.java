package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.General;
import pages.HomePage;
import utils.DriverFactory;

public class HomeSteps {
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    General general = new General(DriverFactory.getDriver());
    @Given("Direct User to Home Page")
    public void directUserToHomePage() {
        //It goes to the site directly by beforeMethod
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        general.checkCookiePopUp();
    }


    @Then("Check the Title of Browser as it is:{string}")
    public void checkTheTitleOfBrowserAsItIs(String expectedTitle) {
        String actualTitle = homePage.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title does not match with the expected one");
    }

    @When("Check the About Coffee Button and Click That")
    public void checkTheAboutCoffeeButtonAndClickThat() {

        homePage.checkAndClickAboutCoffee();
    }


    @Then("Check the below items: {string}, {string}, {string}, {string},{string}")
    public void checkTheBelowItems(String item1, String item2, String item3, String item4, String item5) {
        homePage.checkElementsBelowAboutCoffee(item1);
        homePage.checkElementsBelowAboutCoffee(item2);
        homePage.checkElementsBelowAboutCoffee(item3);
        homePage.checkElementsBelowAboutCoffee(item4);
        homePage.checkElementsBelowAboutCoffee(item5);
    }

    @Then("Check the items of Second Navbar")
    public void checkTheItemsOfSecondNavbar() {
        homePage.checkSecondNavbarsItems();
    }
}
