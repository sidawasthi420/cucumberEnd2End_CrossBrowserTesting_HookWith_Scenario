package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SnapDealHomePage {
    private WebDriver driver;

    @FindBy(id="pushDenied")
	private WebElement popoverMessage;
    
    @FindBy(xpath="//div[@class='inputValEntered hidden']//preceding::input[starts-with(@placeholder,'Search products')]")
	private WebElement searchBox;
    
    @FindBy(xpath="//div[@id='searchMessageContainer']//descendant::span")
    private WebElement searchedResultText;
    
    public SnapDealHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void dismissPopoverIfDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        try {
        	popoverMessage.click();
        } catch (Exception ex) {
            System.out.println("popover didn't appeared");
        }
        Thread.sleep(3000);
    }

    public void launchApplication() {
        driver.get("https://www.snapdeal.com/");
    }

    public boolean isOnHomePage() {
        String expectedTitle = "Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items";
        String actualTitle = driver.getTitle();
        return actualTitle.equals(expectedTitle);
    }

    public void enterProductToSearch(String product) throws InterruptedException {
    	searchBox.sendKeys(product);
        Thread.sleep(4000);
    }

    public void clickSearchButton(String product) throws InterruptedException {
        // Use dynamic locator for product suggestion
        WebElement searchSuggestion = driver.findElement(By.xpath("//span[text()='" + product + "']//parent::a"));
        searchSuggestion.click();
        Thread.sleep(4000);
    }

    public boolean isProductSearchResultsDisplayed(String expectedText) throws InterruptedException {
        String actualText = searchedResultText.getText();
        Thread.sleep(4000);
        return actualText.contains(expectedText);
    }
}