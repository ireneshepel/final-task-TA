package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JoinPage extends BasePage{

    @FindBy(xpath = "//input[@aria-label='Join ASOS']")
    private WebElement joinButton;

    @FindBy(xpath = "//select[@aria-label='Date of birth Year']/option")
    private List<WebElement> yearBirthOption;

    @FindBy(xpath = "//select[@aria-label='Date of birth Year']")
    private WebElement yearBirthDropDownList;

    @FindBy(xpath = "//select[@aria-label='Date of birth Month']/option")
    private List<WebElement> monthBirthOption;

    @FindBy(xpath = "//select[@aria-label='Date of birth Month']")
    private WebElement monthBirthDropDownList;

    @FindBy(xpath = "//select[@aria-label='Date of birth Day']/option")
    private List<WebElement> dayBirthOption;

    @FindBy(xpath = "//select[@aria-label='Date of birth Day']")
    private WebElement dayBirthDropDownList;

    @FindBy(xpath = "//input[@data-st-field='id-register-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@data-st-field='id-register-firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@data-st-field='id-register-lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@data-st-field='id-register-password']")
    private WebElement passwordField;

    public JoinPage(WebDriver driver) { super(driver); }

    public void clickYearBirthDropDownList() { yearBirthDropDownList.click();}

    public void clickYearBirthOption() { yearBirthOption.get(1).click();}

    public void clickMonthBirthDropDownList() { monthBirthDropDownList.click();}

    public void clickMonthBirthOption() { monthBirthOption.get(1).click();}

    public void clickDayBirthDropDownList() { dayBirthDropDownList.click();}

    public void clickDayBirthOption() { dayBirthOption.get(1).click();}

    public void enterTextInPasswordField(final String passwordText) { passwordField.sendKeys(passwordText); }

    public void enterTextInEmailField(final String emailText) {
        emailField.sendKeys(emailText);
    }

    public void enterTextInFirstNameField(final String firstNameText) {
        firstNameField.sendKeys(firstNameText);
    }

    public void enterTextInLastNameField(final String lastNameText) {
        lastNameField.sendKeys(lastNameText);
    }

    public boolean isJoinButtonEnabled() {return joinButton.isEnabled();}
}
