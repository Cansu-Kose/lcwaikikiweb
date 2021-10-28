import org.apache.log4j.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {

    WebDriver driver;

    @Before
    public void setup() {
        //Chrome Driver location.
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cansu\\IdeaProjects\\TestiniumJobApp\\TestiniumJobApp\\chromedriver");
        //Creating a new ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testOneHomepage() throws InterruptedException {

        //Creating Logger
        final Logger logger = Logger.getLogger(this.getClass());
        PropertyConfigurator.configure("src/log4j.properties");

        //Test Case for lcwaikiki home page
        LCWaikikiHomePage homePage;
        homePage = new LCWaikikiHomePage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lcwaikiki.com/tr-TR/TR"); //Checking if the HomePage is open.
        logger.debug("Homepage opened successfully.");
        homePage.clickOnLoginButton(); // Login Page
        Thread.sleep(3000); //Waiting  load the page.

        //Test Case for lcwaikiki login page.
        LCWaikikiLoginPage loginPage; //Creating a LoginPage element.
        loginPage = new LCWaikikiLoginPage(driver);
        loginPage.setLoginMail("cansuu23977@gmail.com"); //Login information.
        loginPage.setLoginPassword("Cansu23977.");
        loginPage.clickOnLogin();
        Thread.sleep(3000); //Waiting.
        Assert.assertTrue((driver.findElements(By.className("dropdown-toggle")).size() < 4)); //Checking if the Login successful.
        logger.debug("Log in successful.");

        //Test Case for lcwaikiki Search Page Change.
        Thread.sleep(2000);
        SearchPageChange searchPageChange; //Creating a searchPageChange element.
        searchPageChange = new SearchPageChange(driver);
        searchPageChange.clickSearchBox();
        searchPageChange.setSearchBox("pantolan"); //Sending keyword to Search box.
        Thread.sleep(2000); //Waiting.
        searchPageChange.clickSearchButton();
        Assert.assertEquals("https://www.lcwaikiki.com/tr-TR/TR/arama?q=pantolan", driver.getCurrentUrl()); //Checking if the second page of the committed search is opened.
        logger.debug("Search page opened successfully.");

        //Test Case for choosing random product.
        ChooseProduct chooseProduct; //Creating a ChooseProduct element.
        chooseProduct = new ChooseProduct(driver);
        chooseProduct.ClickMoreElements(); //
        logger.debug("More elements clicked successfully.");
        Thread.sleep(3000); //Waiting.
        chooseProduct.chooseRandomProduct();
        String pagePrice = chooseProduct.productPrice(); //Getting  value of the product.

        //Test Case for adding a product to cart.
        AddToCart addToCart;
        addToCart = new AddToCart(driver);
        addToCart.chooseSize();
        addToCart.clickAddToCartButton(); //Adding product to the cart.
        Thread.sleep(3000); //Waiting load the page.
        addToCart.clickCartHolder(); //Opening cart page.
        Thread.sleep(3000);
        String cartPrice = addToCart.cartPrice(); //Getting  value of price.
        Assert.assertEquals(pagePrice, cartPrice); //Checking the prices.
        logger.debug("Product price matches with the cart price.");

        //Test Case for increasing the quantity of product in cart to 2
        IncreaseProductQuantity increaseProductQuantity;
        increaseProductQuantity = new IncreaseProductQuantity(driver);
        increaseProductQuantity.clickIncreaseQuantityButton(); //Increasing the quantity of the product.
        Thread.sleep(3000); //Waiting load the page.
        int quantity = increaseProductQuantity.getCurrentQuantity();
        Assert.assertEquals(quantity, 2); //Checking the quantity of the product.
        logger.debug("Product quantity increased successfully.");

        //Test Case for deleting items card
        ClearCart clearCart; //Creating a ClearCart element.
        clearCart = new ClearCart(driver);
        clearCart.clickClearCartButton();
        Thread.sleep(2000);
        clearCart.clickClearConfirmButton();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.id("spanCart")).size() > 0); //Checking if the cart is empty.
        logger.debug("Product has been removed from the cart successfully.");


    }


    @After
    public void close() {
        driver.close();
    }


}
