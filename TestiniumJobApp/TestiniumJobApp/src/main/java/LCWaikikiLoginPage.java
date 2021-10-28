import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LCWaikikiLoginPage {
    WebDriver driver;

    //mail address for login.
    @FindBy(how = How.ID, using = "LoginEmail")
    private WebElement loginMail;

    //password box.
    @FindBy(how = How.ID, using = "Password")
    private WebElement loginPassword;

    //Login button.
    @FindBy(how = How.ID, using = "loginLink")
    private WebElement loginButton;

    public LCWaikikiLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //mail box.
    public void setLoginMail(String strEmail) {
        loginMail.sendKeys(strEmail);
    }

    //password box.
    public void setLoginPassword(String password) {
        loginPassword.sendKeys(password);
    }

    //Click function.
    public void clickOnLogin() {
        loginButton.click();
    }


}
