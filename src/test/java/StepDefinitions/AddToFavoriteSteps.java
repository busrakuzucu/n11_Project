package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;

public class AddToFavoriteSteps {
    DialogContent dc = new DialogContent();
    ArrayList<String> list = new ArrayList<>();

    @And("Choose products randomly from search list")
    public void chooseProductsRandomlyFromSearchList() {


        for (int i = 0; i < 4; i++) {
            int random = dc.randomGenerator(dc.addToFavoriteButton.size());
            list.add(dc.searchList.get(random).getAttribute("title"));
            dc.jsClickFunction(dc.addToFavoriteButton.get(random));
        }
    }

    @Then("Verify that the products are in the favorite list")
    public void verifyThatTheProductsAreInTheFavoriteList() {

        ArrayList<String> sonucList = new ArrayList<>();
        for (WebElement e : dc.wishList) {
            sonucList.add(e.getAttribute("title"));
        }
        Assert.assertTrue(sonucList.containsAll(list));
    }
}
