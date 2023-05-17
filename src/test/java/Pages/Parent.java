package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parent {
    public Parent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

    public void clickFunction(WebElement element) {
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void sendKeysFunction(WebElement element, String text) {
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }


    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void jsClickFunction(WebElement element) {
        waitUntilClickable(element);
        js.executeScript("arguments[0].click();", element);
    }

    public void n11Cookies() {

        List<WebElement> cookieCampaignClose = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//*[text()='Daha Sonra']"), 3));
        List<WebElement> cookieLocationClose = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.id("myLocation-close-info"), 2));

        if (cookieCampaignClose.size() > 0) {
            WebElement campaignClose = GWD.getDriver().findElement(By.xpath("//*[text()='Daha Sonra']"));
            clickFunction(campaignClose);
        }

        if (cookieLocationClose.size() > 0) {
            WebElement locationClose = GWD.getDriver().findElement(By.id("myLocation-close-info"));
            clickFunction(locationClose);
        }
    }

    public int randomGenerator(int max) {
        return (int) (Math.random() * max);
    }
    public WebElement getTheHighestPrice(Map<WebElement, Double> prices) {
        double max = 0;
        WebElement webElement = null;
        for (Map.Entry<WebElement, Double> kv : prices.entrySet()) {
            if (max < kv.getValue()) {
                max = kv.getValue();
                webElement = kv.getKey();
            }
        }
        return webElement;
    }

    public WebElement getPrices(List<WebElement> allPrices) {
        Map<WebElement, Double> prices = new HashMap<>();
        for (WebElement p : allPrices) {
            prices.put(p, strToDoublePrice(p.getText()));
        }
        return getTheHighestPrice(prices);
    }

    public double strToDoublePrice(String getText) {
        String lastPriceStr = getText.replaceAll("[^0-9]", "");
        return Double.parseDouble(lastPriceStr);
    }
}

