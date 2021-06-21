package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage extends BasePage{

    @FindBy(xpath = "//h2[@class='empty-bag-title']")
    private WebElement emptyBagMessage;

    public BagPage(WebDriver driver) { super(driver); }

    public boolean isEmptyBagMessageVisible() { return emptyBagMessage.isDisplayed(); }

    public WebElement getEmptyBagMessage() { return emptyBagMessage; }


}
