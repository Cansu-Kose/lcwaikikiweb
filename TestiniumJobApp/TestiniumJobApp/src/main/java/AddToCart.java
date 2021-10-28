import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;




public class AddToCart {

    WebDriver driver;
    //add to cart button.
    @FindBy(how = How.ID, using = "pd_add_to_cart")
    private WebElement addToCartButton;
    //open cart button.
    @FindBy(how = How.XPATH, using = "//a[@class='header-cart']")
    private WebElement cartHolder;
    @FindBy(how = How.XPATH, using = "//*[@id=\"option-size\"]/a[1]")
    private WebElement chooseSize;

    public  AddToCart(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //add to cart button.
    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void chooseSize(){
        chooseSize.click();
    }
    //cart button.
    public void clickCartHolder( ) {
        cartHolder.click();
    }
    //Card Price.
    public String cartPrice(){
        String[] cart_price = driver.findElement(By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div[2]/div[1]/div[5]/div/span[2]")).getText().split(" ");
        String cartPrice = cart_price[0];
        return cartPrice;
    }
}
