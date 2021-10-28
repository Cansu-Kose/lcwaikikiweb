import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LCWaikikiHomePage {
    WebDriver driver;

    //link for the start main page.
    private static String MainPageUrl = "https://www.lcwaikiki.com/tr-TR/TR";

    //Login button on main page.
    @FindBy(how = How.LINK_TEXT, using = "Giriş Yap")
    private WebElement loginButton;

    //Constructor
    public LCWaikikiHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(MainPageUrl);
        PageFactory.initElements(driver, this);
    }

    //Login button click.
    public void clickOnLoginButton() {
        loginButton.click();
    }


}
