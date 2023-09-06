package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MachinesPage;
import utils.DriverFactory;

public class MachinesSteps {
    MachinesPage machinesPage = new MachinesPage(DriverFactory.getDriver());
    @When("Click the Machines Dropdown")
    public void clickTheMachinesDropdown() {
        machinesPage.clicktheMachinesDropdown();
    }

    @When("Click the Shop Machines Parts Button")
    public void clickTheShopMachinesPartsButton() {
        machinesPage.clicktheShopMachinesParts();
    }

    @Then("Check Bean Lid the Product")
    public void checkBeanLidTheProduct() {
        machinesPage.checktheBeanLid();
    }
}
