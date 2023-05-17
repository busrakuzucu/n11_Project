package StepDefinitions;

import io.cucumber.java.en.*;
import Pages.DialogContent;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class FromFavoriteToCart {
    DialogContent dc=new DialogContent();
    String name="";
    @When("Choose and add product the highest from favorite list")
    public void chooseAndAddProductTheHighestFromFavoriteList() {

        dc.clickFunction(dc.getPrices(dc.allPrices));
        name=dc.productName.getText();
    }
    @Then("Verify that favorite product is in the cart")
    public void verifyThatFavoriteProductIsInTheCart() {
        boolean flag=false;
        for (WebElement e: dc.sepettekiUrunler){
            if (e.getText().equals(name)){
                flag=true;
            }
        }
        Assert.assertTrue(flag);
    }
}
