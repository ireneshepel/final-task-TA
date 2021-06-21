package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import pages.ProductPage;
import pages.JoinPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 120;
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    SearchResultsPage searchResultsPage;
    SingInPage singInPage;
    WishListPage wishListPage;
    BagPage bagPage;
    PreferencesPage preferencesPage;
    JoinPage joinPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("User open {string} page")
    public void userOpenHomePagePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage.enterTextInSearchField(keyword);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickSearchButton();
    }

    @And("User clicks wish list on first product")
    public void userClicksWishListOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickWishListOnFirstProduct();
    }

    @And("User clicks wish list button")
    public void userClicksWishListButton() {
        homePage.clickWishListButton();
    }

    @Then("User checks that amount of products in wish list are {string}")
    public void userChecksThatAmountOfProductsInWishListAreAmountOfProducts(final String expectedAmount) {
        wishListPage = pageFactoryManager.getWishListPage();
        wishListPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishListPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, wishListPage.getWishListProductsCount());
        assertEquals(wishListPage.getAmountOfProductsInWishList(),expectedAmount);
    }

    @And("User checks 'My Account' button visibility")
    public void userChecksMyAccountButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isMyAccountButtonVisible();
    }

    @When("User clicks 'My Account' button")
    public void userClicksMyAccountButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountButton());
        homePage.clickMyAccountButton();
    }

    @And("User checks 'Sing in' button visibility")
    public void userChecksSingInButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSignInButtonVisible();
    }

    @And("User clicks 'Sing in' button")
    public void userClicksSingInButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickSignInButton();
    }

    @And("User enters email {string}")
    public void userEntersEmailEmail(final String email) {
        singInPage = pageFactoryManager.getSingInPage();
        singInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        singInPage.enterTextInEmailField(email);
    }

    @Then("User should have error message")
    public void userShouldHaveErrorMessage() {
        singInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, singInPage.getEmailErrorMessage());
        assertTrue(singInPage.isEmailErrorMessageVisible());
    }

    @And("User enters password {string}")
    public void userEntersPasswordPassword(final String password) {
        singInPage = pageFactoryManager.getSingInPage();
        singInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        singInPage.enterTextInPasswordField(password);
    }

    @And("User checks that he is logged into account")
    public void userChecksThatHeIsLoggedIntoAccount() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isWelcomeMessageVisible());
    }

    @And("User clicks on first product")
    public void userClicksOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickImageOnFirstProduct();
    }

    @And("User clicks on size drop-down list")
    public void userClicksOnSizeDropDownList() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickSizeDropDownList();
    }

    @And("User clicks on first available size")
    public void userClicksOnFirstSize() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickFirstOptionOfSizeList();
    }

    @And("User clicks on 'Add to Bag' button")
    public void userClicksOnAddToBagButton() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickAddToBagButton();
    }

    @Then("User checks that amount of products in bag are {string}")
    public void userChecksThatAmountOfProductsInBagAreAmountOfProducts(final String expectedAmount) {
        //productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(productPage.getAmountOfProductsInBag(), expectedAmount);
    }

    /*@Then("User clicks on 'My bag' button")
    public void userClicksOnBagButton() {
        /*Then User clicks on 'My bag' button
    And User checks that amount of products in bag are '<amountOfProducts>'*/
    //}

    @And("User clicks on 'My bag' pop-up close button")
    public void userClicksOnMyBagPopUpCloseButton() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickMyBagCloseButton();
    }

    @And("User checks 'My bag' pop-up visibility")
    public void userChecksMyBagPopUpVisibility() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getMyBagPopUp());
    }

    @And("User clicks on 'My bag' button")
    public void userClicksOmMyBagButton() {
        productPage.clickMyBagButton();
    }

    @And("User deletes product from bag")
    public void userDeletesProductFromBag() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getDeleteProductFromMyBagButton());
        productPage.clickDeleteProductFromMyBagButton();
    }

    @Then("User checks that bag empty")
    public void userChecksThatBagEmptyEmptyBag() {
        bagPage = pageFactoryManager.getBagPage();
        bagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bagPage.getEmptyBagMessage());
        assertTrue(bagPage.isEmptyBagMessageVisible());

    }

    @Then("User clicks on bag button on 'My bag' pop-up")
    public void userClicksOnEmptyBagButton() {
        //productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickBagOnPopUpButton();
        // And User //clicks on 'My bag' pop-up close button
        //
        /* And User //clicks on 'My bag' pop-up close button
    And User checks that amount of products in bag are '<amountOfProducts>'
    And User //clicks on 'My bag' button
    And User checks 'My bag' pop-up visibility*/
        //And User checks 'My bag' pop-up visibility

    }

    @And("User checks email field visibility")
    public void userChecksEmailFieldVisibility() {
        singInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, singInPage.getEmailField());
    }

    @And("User clicks button to sign into account")
    public void userClicksButtonToSignIntoSite() {
        singInPage.clickSingInButton();
    }

    @And("User clicks sort drop-down list")
    public void userClicksSortDropDownList() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickSortDropDownList();
    }

    @And("User clicks 'Price high to low' option")
    public void userClicksPriceHighToLowOption() {
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getSortPriceHighToLowButton());
        searchResultsPage.clickSortPriceHighToLowButton();
    }

    @Then("User checks that prices is in descending order")
    public void userChecksThatPriceIsInDescendingOrder() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.comparePrices());

    }

    @When("User clicks 'New in' button")
    public void userClicksNewInButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickNewInButton();
    }

    @And("User clicks 'Face + Body' button")
    public void userClicksFaceBeautyButton() {
        //homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getFacePlusBodyButton());
        homePage.clickFacePlusBodyButton();
    }

    @And("User clicks 'Women' clothes button")
    public void userClicksWomenClothesButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickWomenClothesButton();
    }

    @And("User checks button to sign into account visibility")
    public void userChecksButtonToSignIntoAccountVisibility() {
        assertTrue(singInPage.isSignInButtonVisible());
    }

    @When("User clicks 'Country select' button")
    public void userClicksCountrySelectButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickCountrySelectButton();
    }

    @And("User clicks currency drop-down list")
    public void userClicksCurrencyDropDownList() {
        preferencesPage = pageFactoryManager.getPreferencesPage();
        preferencesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        preferencesPage.clickCurrencyDropDownList();
    }

    @And("User clicks 'USD' currency option")
    public void userClicksUSDCurrencyOption() {
        preferencesPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, preferencesPage.getUsdCurrencyOption());
        preferencesPage.clickUsdCurrencyOption();
    }

    @And("User clicks 'Update Preferences' button")
    public void userClicksUpdatePreferencesButton() {
        preferencesPage.clickUpdatePreferencesButton();
    }

    @And("User checks that correct currency is selected")
    public void userChecksThatCorrectCurrencyIsSelected() {
        preferencesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(preferencesPage.isUsdCurrencyOptionSelected());
    }

    @And("User checks 'Join' button visibility")
    public void userChecksJoinButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isJoinButtonVisible();
    }

    @And("User clicks 'Join' button")
    public void userClicksJoinButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickJoinButton();
    }

    @And("User enters password {string} in register form")
    public void userEntersPasswordPasswordInRegisterForm(final String password) {
        joinPage = pageFactoryManager.getJoinPage();
        joinPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        joinPage.enterTextInPasswordField(password);
    }


    @And("User enters email {string} in register form")
    public void userEntersEmailEmailInRegisterForm(final String email) {
        joinPage = pageFactoryManager.getJoinPage();
        joinPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        joinPage.enterTextInEmailField(email);
    }

    @And("User enters first name {string} in register form")
    public void userEntersFirstNameFirstNameInRegisterForm(final String firstName) {
        joinPage.enterTextInFirstNameField(firstName);
    }

    @And("User enters last name {string} in register form")
    public void userEntersLastNameLastNameInRegisterForm(final String lastName) {
        joinPage.enterTextInLastNameField(lastName);
    }

    @And("User selects day of birth")
    public void userSelectsDayOfBirth() {
        joinPage.clickDayBirthDropDownList();
        joinPage.clickDayBirthOption();
    }

    @And("User selects month of birth")
    public void userSelectsMonthOfBirth() {
        joinPage.clickMonthBirthDropDownList();
        joinPage.clickMonthBirthOption();
    }

    @And("User selects year of birth")
    public void userSelectsYearOfBirth() {
        joinPage.clickYearBirthDropDownList();
        joinPage.clickYearBirthOption();
    }

    @Then("User checks 'Join Asos' button is enabled")
    public void userChecksJoinAsosButtonIsEnabled() {
        assertTrue(joinPage.isJoinButtonEnabled());
    }

    @Then("User should have 'Nothing matches your search' message appears on the site")
    public void userShouldHaveNothingMatchesYourSearchMessageAppearsOnTheSite() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.isNothingMatchesMessage());
    }

    @Then("User checks header visibility")
    public void userChecksHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isHeaderVisible());
    }

    @And("User checks footer visibility")
    public void userChecksFooterVisibility() {
        assertTrue(homePage.isFooterVisible());
    }

}
