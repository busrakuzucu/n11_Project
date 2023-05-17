package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(linkText = "Giriş Yap")
    public WebElement signIn;
    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "loginButton")
    public WebElement loginButton;
    @FindBy(xpath = "//a[@title='Hesabım']")
    public WebElement account;
    @FindBy(css = "[class='errorText']")
    public List<WebElement> errorText;
    @FindBy(css = "[title='Elektronik']")
    public WebElement elektronik;
    @FindBy(css = "[title='Bilgisayar']")
    public WebElement bilgisayar;
    @FindBy(css = "[title='Dizüstü Bilgisayar']")
    public WebElement dizustuBilgisayar;
    @FindBy(id = "minPrice")
    public WebElement minPrice;
    @FindBy(id = "maxPrice")
    public WebElement maxPrice;
    @FindBy(css = "[id='brand-islemci-Intel-Core-i7']+span")
    public WebElement intelCoreI7;
    @FindBy(css = "[data-hdfl='islemci']>h2")
    public WebElement islemci;
    @FindBy(css = "[data-hdfl='bellekkapasitesi']>h2")
    public WebElement bellekKapasitesi;
    @FindBy(css = "[id='brand-bellekkapasitesi-32-GB']+span")
    public WebElement otuzIkiGB;
    @FindBy(css = "[class='productName']")
    public List<WebElement> productNames;
    @FindBy(css = "[class='btnBasket']")
    public List<WebElement> addToBasketButtons;
    @FindBy(css = "[title='Sepetim']")
    public WebElement sepet;
    @FindBy(css = "[class='prodDescription']")
    public List<WebElement> sepettekiUrunler;

    @FindBy(css ="input[id='searchData']")
    public WebElement inputSearch;

    @FindBy(css ="[class='searchBtn']>span")
    public WebElement searchButton;

    @FindBy(css ="[title='Favorilere ekle']")
    public List<WebElement> addToFavoriteButton;

    @FindBy(css ="i[class='iconFavoritesWhite']")
    public WebElement favoriteButton;

    @FindBy(xpath = "//div[@class='pro']/a[(contains(a,@tabindex))]")
    public List<WebElement> searchList;

    @FindBy(css = "div[class='pro']>a[itemprop='url']")
    public List<WebElement> wishList;

    @FindBy(xpath = "//div[@class='proDetail']/a[@class='price']")
    public List<WebElement> allPrices;

    @FindBy(css = "[title='Sepete Ekle']")
    public WebElement sepeteEkle;

    @FindBy (css="[class='proName']")
    public WebElement productName;
    public WebElement getWebElement(String element) {

        switch (element) {
            case "elektronik": return elektronik;
            case "bilgisayar": return bilgisayar;
            case "dizustuBilgisayar": return dizustuBilgisayar;
            case "minPrice": return minPrice;
            case "maxPrice": return maxPrice;
            case "intelCoreI7": return intelCoreI7;
            case "islemci": return islemci;
            case "bellekKapasitesi": return bellekKapasitesi;
            case "otuzIkiGB": return otuzIkiGB;
            case "sepet": return sepet;
            case "inputSearch": return inputSearch;
            case "searchButton": return searchButton;
            case "favoriteButton":return favoriteButton;
            case "sepeteEkle":return sepeteEkle;




        }
        return null;
    }
}
