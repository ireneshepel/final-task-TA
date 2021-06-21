package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@class='IIfXyce']")
    private WebElement footer;

    @FindBy(xpath = "//nav[@class='_3EAPxMS']//div[@class='_3C_NQPb']")
    private WebElement header;

    @FindBy(xpath = "//a[contains(text(), 'Join')]")
    private WebElement joinButton;

    @FindBy(xpath = "//div[@class='_25L--Pi']//button[@data-testid='country-selector-btn']")
    private WebElement countrySelectorButton;

    @FindBy(xpath = "//div[@id='1020946c-8949-4e9c-9719-43435002bcd4']//ul[@aria-labelledby='new-products-a11']//a[contains(text(), 'Face + Body')]")
    private WebElement facePlusBodyButton;

    @FindBy(xpath = "//button[@aria-controls='1020946c-8949-4e9c-9719-43435002bcd4']//span[contains(text(), 'New in')]")
    private WebElement newInButton;

    @FindBy(xpath = "//a[@data-testid='women-floor']")
    private WebElement womenClothesButton;

    @FindBy(xpath = "//span[@class='tiqiyps']")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement wishListButton;

    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement myAccountButton;

    @FindBy(xpath = /*"//a[@data-testid='myaccount-link']"*/ "//a[@data-testid='signin-link']")
    private WebElement signInButton;

    public HomePage(WebDriver driver) { super(driver); }

    public void openHomePage(String url) { driver.get(url); }

    public boolean isFooterVisible() { return footer.isDisplayed(); }

    public boolean isHeaderVisible() { return header.isDisplayed(); }

    public boolean isSearchFieldVisible() { return searchField.isDisplayed(); }

    public boolean isSignInButtonVisible() { return signInButton.isDisplayed(); }

    public boolean isMyAccountButtonVisible() { return myAccountButton.isDisplayed(); }

    public boolean isWelcomeMessageVisible() { return welcomeMessage.isDisplayed(); }

    public boolean isJoinButtonVisible() { return joinButton.isDisplayed(); }

    public void enterTextInSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText); }

    public void clickSearchButton() { searchButton.click(); }

    public void clickSignInButton() {
        Actions signIn = new Actions(driver);
        signIn.moveToElement(signInButton).click().build().perform();
    }

    public void clickWishListButton() { wishListButton.click();}

    public void clickNewInButton() {
        Actions newIn = new Actions(driver);
        newIn.moveToElement(newInButton).click().perform();
    }

    public void clickMyAccountButton() {
        Actions myAccount = new Actions(driver);
        myAccount.moveToElement(myAccountButton).build().perform();
    }

    public void clickJoinButton() {
        Actions join = new Actions(driver);
        join.moveToElement(joinButton).click().build().perform();
    }

    public WebElement getMyAccountButton() { return myAccountButton; }

    public WebElement getFacePlusBodyButton() { return facePlusBodyButton; }

    public void clickFacePlusBodyButton() { facePlusBodyButton.click();}

    public void clickWomenClothesButton() { womenClothesButton.click();}

    public void clickCountrySelectButton() { countrySelectorButton.click();}

}

