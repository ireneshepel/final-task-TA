package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WishListPage extends BasePage{

    @FindBy(xpath = "//div[@class='itemCount_3vWat']")
    private WebElement wishListProductsCount;

    public WishListPage(WebDriver driver) { super(driver); }

    public String getAmountOfProductsInWishList() { return wishListProductsCount.getText(); }

    public WebElement getWishListProductsCount() { return wishListProductsCount; }
}
