package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public WishListPage getWishListPage() {
        return new WishListPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() { return new SearchResultsPage(driver); }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SingInPage getSingInPage() { return new SingInPage(driver); }

    public BagPage getBagPage() { return new BagPage(driver); }

    public PreferencesPage getPreferencesPage() { return new PreferencesPage(driver); }

    public JoinPage getJoinPage() { return new JoinPage(driver); }

}
