package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class MachinesPage {
    ElementHelper helper;

    By drd_Machines = By.cssSelector("summary.text-with-icon.link-faded-reverse[data-url='/pages/compare-our-machine-bundles']");
    By btn_ShopMachineParts = By.xpath("//span[@class='reversed-link hover:show' and text()='Shop Machine Parts']");
    By btn_BeanLid = By.xpath("//a[contains(text(),'Bean Lid')]");
    By txt_BeanLid = By.cssSelector(".tp-display-2");
    public MachinesPage(WebDriver driver){
        this.helper = new ElementHelper(driver);
    }

    public void clicktheMachinesDropdown(){
        helper.click(drd_Machines);
    }
    public void clicktheShopMachinesParts(){
        helper.click(btn_ShopMachineParts);
    }
    public void checktheBeanLid(){
        helper.checkElement(btn_BeanLid);
        helper.click(btn_BeanLid);
        helper.checkElement(txt_BeanLid);
    }


}
