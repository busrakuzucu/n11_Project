package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class AddToCartByFilteringSteps {

    DialogContent dc = new DialogContent();
    String name="";
    @When("Hower to element in dialog content")
    public void howerToElementInDialogContent(DataTable dt) {
        List<String> howers = dt.asList(String.class);
        for (String h:howers){
            WebElement e =dc.getWebElement(h);
            dc.waitUntilClickable(e);
            new Actions(GWD.getDriver()).moveToElement(e).build().perform();
        }
    }

    @And("Click on the element in dialog content")
    public void clickOnTheElementInDialogContent(DataTable dt) {
        List<String> buttons = dt.asList(String.class);
        for (String b:buttons){
            WebElement e = dc.getWebElement(b);
            dc.clickFunction(e);
        }
    }

    @And("Send key to element in dialog content")
    public void sendKeyToElementInDialogContent(DataTable dt) {
        List<List<String>> items = dt.asLists(String.class);
        for (int i = 0; i < items.size(); i++) {
            WebElement e = dc.getWebElement(items.get(i).get(0));
            dc.sendKeysFunction(e,items.get(i).get(1));
        }
    }

    @And("jsClick on the element in dialog content")
    public void jsclickOnTheElementInDialogContent(DataTable dt) {
        List<String> buttons = dt.asList(String.class);
        for (String b:buttons){
            WebElement e = dc.getWebElement(b);
            dc.jsClickFunction(e);
        }
    }

    @And("Add the product to the basket randomly from result list")
    public void addTheProductToTheBasketRandomlyFromResultList() {
        int random = dc.randomGenerator(dc.addToBasketButtons.size());
        name = dc.productNames.get(random).getText();
        dc.clickFunction(dc.addToBasketButtons.get(random));
    }

    @Then("Verify that the product is in the cart")
    public void verifyThatTheProductIsInTheCart() {
        boolean flag=false;
        for (WebElement e: dc.sepettekiUrunler){
            if (e.getText().equals(name)){
                flag=true;
            }
        }
        Assert.assertTrue(flag);
    }
}
