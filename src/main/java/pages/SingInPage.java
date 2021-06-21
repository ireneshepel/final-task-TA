package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingInPage extends BasePage{

    @FindBy(xpath = "//input[@id='EmailAddress']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@data-st-field='id-signIn-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement singInButton;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement emailErrorMessage;

    public SingInPage(WebDriver driver) { super(driver); }

    public void enterTextInEmailField(final String emailText) {
        emailField.sendKeys(emailText);
    }

    public void enterTextInPasswordField(final String passwordText) {
        passwordField.sendKeys(passwordText);
    }

    public boolean isEmailErrorMessageVisible() { return emailErrorMessage.isDisplayed(); }

    public WebElement getEmailErrorMessage() { return emailErrorMessage; }

    public WebElement getEmailField() { return emailField; }

    public boolean isEmailFieldVisible() { return emailField.isDisplayed(); }

    public void clickSingInButton() { singInButton.click(); }

    public boolean isSignInButtonVisible() { return singInButton.isDisplayed(); }

}
