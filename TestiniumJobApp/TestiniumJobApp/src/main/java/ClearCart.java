import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClearCart {
    WebDriver driver;

    //Clear cart button.
    @FindBy(xpath = "//a[@class='cart-square-link']")
    public WebElement clearCartButton;

    @FindBy(xpath = "//a[@class='inverted-modal-button sc-delete ins-init-condition-tracking']")
    public WebElement clearConfirm;

    public ClearCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //clear cart button.
    public void clickClearCartButton() {
        clearCartButton.click();
    }

    public void clickClearConfirmButton() {
        clearConfirm.click();
    }


}
