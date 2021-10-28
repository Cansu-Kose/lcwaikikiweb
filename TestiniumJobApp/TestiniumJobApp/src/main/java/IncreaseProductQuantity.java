import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class IncreaseProductQuantity {
    WebDriver driver;

    //increase quantity button.
    @FindBy(xpath = "//div[1]/div[1]/div[1]/div/div[1]/div/a[2]")
    public WebElement increaseQuantityButton;

    public IncreaseProductQuantity(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //increase quantity button.
    public void clickIncreaseQuantityButton() {
        increaseQuantityButton.click();
    }

    //Get current quantity of the product from cart page.
    public int getCurrentQuantity() {
        WebElement checkQuantity = driver.findElement(By.xpath("//input[@class='item-quantity-input ignored']"));
        int quantity = Integer.parseInt(checkQuantity.getAttribute("value"));
        return quantity;
    }


}
