package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//button[@aria-label='Delete this item']")
    private WebElement deleteProductFromMyBagButton;

    @FindBy(xpath = "//button[@data-testid='minibag-close-btn']")
    private WebElement myBagCloseButton;

    @FindBy(xpath = "//div[@data-testid='minibag-dropdown']//div[@class='Z8dxicz']")
    private WebElement myBagPopUp;

    @FindBy(xpath = "//div[contains(@data-bind, 'sizeDropdownVisible()')]")
    private WebElement sizeDropDownList;

    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement bagProductCount;

    @FindBy(xpath = "//button[@data-testid='miniBagIcon']")
    private WebElement bagProductButton;

    @FindBy(xpath = "//a[@data-test-id='bag-link']")
    private WebElement bagOnPopUpButton;

    @FindBy(xpath = "//select[@data-id='sizeSelect']/option")
    private List<WebElement> productSizeList;

    @FindBy(xpath = "//span[@data-bind='text: buttonText']")
    private WebElement addToBagButton;

    public ProductPage(WebDriver driver) { super(driver); }

    public void clickSizeDropDownList() { sizeDropDownList.click();}

    public void clickFirstOptionOfSizeList() { productSizeList.get(1).click();}

    public void clickAddToBagButton() { addToBagButton.click();}

    //public String getAmountOfProductsInBag() { return bagProductCount.getText(); }

    public String getAmountOfProductsInBag() { return bagProductButton.getAttribute("aria-label"); }

    public void clickMyBagCloseButton() { myBagCloseButton.click();}

    public WebElement getMyBagPopUp() { return myBagPopUp; }

    public void clickMyBagButton() { bagProductButton.click();}

    public void clickDeleteProductFromMyBagButton() { deleteProductFromMyBagButton.click();}

    public WebElement getDeleteProductFromMyBagButton() { return deleteProductFromMyBagButton; }

    public void clickBagOnPopUpButton() { bagOnPopUpButton.click();}

}