package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginSteps {
    DialogContent dc = new DialogContent();

    @Given("Navigate to web site")
    public void navigateToNSite() {
        GWD.getDriver().get("https://www.n11.com/");
    }

    @When("Enter valid username and password")
    public void enterValidUsernameAndPassword() {
        dc.n11Cookies();
        dc.clickFunction(dc.signIn);
        dc.sendKeysFunction(dc.email, "bughunters2023@hotmail.com");
        dc.sendKeysFunction(dc.password, "Brd.2023");
    }

    @And("Click on the login button")
    public void clickOnTheLoginButton() {
        dc.loginButton.click();
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        Assert.assertTrue(dc.account.isDisplayed(), "Login process is fail");
    }


    @When("User enter email as {string}  password  as {string}")
    public void userEnterEmailAsPasswordAs(String email, String password) {
        dc.n11Cookies();
        dc.clickFunction(dc.signIn);
        dc.sendKeysFunction(dc.email, email);
        dc.sendKeysFunction(dc.password, password);
    }

    @Then("User should not login successfully")
    public void userShouldNotLoginSuccessfully() {
        for (WebElement e : dc.errorText) {
            if (e.isDisplayed())
                Assert.assertTrue(e.isDisplayed());
        }
    }

}
