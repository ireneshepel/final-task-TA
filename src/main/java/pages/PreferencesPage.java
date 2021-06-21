package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreferencesPage extends BasePage{

    @FindBy(xpath = "//button[@data-testid='save-country-button']")
    private WebElement updatePreferencesButton;

    @FindBy(xpath = "//select[@id='currency']")
    private WebElement currencyDropDownList;

    @FindBy(xpath = "//option[@value='2']")
    private WebElement usdCurrencyOption;

    public PreferencesPage(WebDriver driver) { super(driver); }

    public void clickCurrencyDropDownList() { currencyDropDownList.click();}

    public WebElement getUsdCurrencyOption() { return usdCurrencyOption;}

    public void clickUsdCurrencyOption() { usdCurrencyOption.click();}

    public void clickUpdatePreferencesButton() { updatePreferencesButton.click();}

    public boolean isUsdCurrencyOptionSelected() { return usdCurrencyOption.isSelected();}
}
