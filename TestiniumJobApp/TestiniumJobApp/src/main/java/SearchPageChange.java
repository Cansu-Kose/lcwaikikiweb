import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class SearchPageChange {

    WebDriver driver;

    //Finding search area.
    @FindBy(how = How.ID, using = "search_input")
    private WebElement searchBox;

    //Finding search button.
    @FindBy(how = How.XPATH, using = "//button[@class='searchButton']")
    private WebElement searchButton;

    //Finding second page button.
    @FindBy(how = How.LINK_TEXT, using = "2")
    private WebElement nextPage;

    public SearchPageChange(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //Searching "pantolan" word
    public void clickSearchBox() {
        searchBox.click();
    }

    //Send key function
    public void setSearchBox(String keys){
        searchBox.sendKeys(keys);
    }

    //Click function
    public void clickSearchButton() {
        searchButton.click();
    }

}
