package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//h2[contains(text(), 'NOTHING MATCHES YOUR SEARCH')]")
    private WebElement nothingMatchesMessage;

    @FindBy(xpath = "//span[@class='_16nzq18']")
    private List<WebElement> productPriceList;

    @FindBy(xpath = "//li[@id='plp_web_sort_price_high_to_low']")
    private WebElement sortPriceHighToLowButton;

    @FindBy(xpath = "//button[@class='_1om7l06']/div[contains(text(), 'Sort')]")
    private WebElement sortDropDownList;

    @FindBy(xpath = "//span[@class='_30BqGyh']")
    private List<WebElement> wishListButton;

    @FindBy(xpath = "//img[@data-auto-id='productTileImage']")
    private List<WebElement> productImageButton;

    public SearchResultsPage(WebDriver driver) { super(driver); }

    public boolean isNothingMatchesMessage() { return nothingMatchesMessage.isDisplayed(); }

    public void clickWishListOnFirstProduct() { wishListButton.get(0).click(); }

    public void clickImageOnFirstProduct() { productImageButton.get(0).click(); }

    public void clickSortDropDownList() { sortDropDownList.click(); }

    public void clickSortPriceHighToLowButton() {
        sortPriceHighToLowButton.click();
    }

    public WebElement getSortPriceHighToLowButton() { return sortPriceHighToLowButton; }

    public WebElement getProductPriceList() { return productPriceList.get(0); }

    public boolean comparePrices() {
        boolean descendOrder = true;
        String firstTitle = productPriceList.get(0).getText();
        Double firstPrice = Double.parseDouble(firstTitle.substring(1));
        for (WebElement webElement : productPriceList) {
            String title = webElement.getText();
            Double price = Double.parseDouble(title.substring(1));
            if (firstPrice-price < 0){
                descendOrder = false;
            }
            firstPrice = price;
        }
        return descendOrder;
    }


}
