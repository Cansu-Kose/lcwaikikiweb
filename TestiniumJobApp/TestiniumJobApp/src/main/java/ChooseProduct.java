import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;


public class ChooseProduct {
    WebDriver driver;

    //Finding all items.
    @FindBy(how = How.XPATH, using = "//*[@id=\"divModels\"]/div[7]/div/div[1]/div")
    private List<WebElement> items;

    @FindBy(how = How.XPATH, using = "//a[@class='lazy-load-button']")
    private WebElement moreElementsButton;

    public ChooseProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickMoreElements() {
        moreElementsButton.click();
    }

    //Choose a random product.
    public void chooseRandomProduct() {
        Random rand = new Random();
        WebElement random = items.get(rand.nextInt(35) + 11);
        random.click();
    }

    //Returning the value of product from the product page.
    public String productPrice() {
        String price = "";
        String[] productPrice = driver.findElement(By.xpath("//*[@id=\"rightInfoBar\"]/div[1]/div/div[2]/div/div/div/span[2]")).getText().split(" ");
        price = productPrice[0];
        return price;
    }

}
