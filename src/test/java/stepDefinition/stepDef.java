package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import hooks.snapDealHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.SnapDealHomePage;

public class stepDef {

public WebDriver driver = snapDealHooks.getDriver();
private SnapDealHomePage homePage = new SnapDealHomePage(driver);
	
	@And("Dismiss the popover if displayed")
	public void dismiss_the_popover_if_displayed() throws InterruptedException {
		homePage.dismissPopoverIfDisplayed();
	}

	@And("Launch the application")
	public void launch_the_application() {
		homePage.launchApplication();
	}

	@Then("User is on the Home page")
	public void user_is_on_the_home_page() {
		if(homePage.isOnHomePage()) {
			System.out.println("Website opened successfully");
		} else {
			System.out.println("Website not opened successfully");
		}
	}

	@When("Enter the required product to search")
	public void enter_the_required_product_to_search() throws InterruptedException {
		homePage.enterProductToSearch("iphone 13 pro back cover");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		homePage.clickSearchButton("iphone 13 pro back cover");
	}

	@Then("^Product search results should be displayed$")
	public void product_search_results_should_be_displayed() throws InterruptedException {
		if(homePage.isProductSearchResultsDisplayed("results for iphone 13 pro back cover")) {
			System.out.println("Results fetched successfully");
		} else {
			System.out.println("Results not fetched successfully");
		}
	}
	
	@Given("Enter {string} and {string}")
	public void open_the_browser(String username, String password) throws InterruptedException {
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
	}
	
	@Then("Enter userdetails for snapdeal")
	public void enter_userdetails_for_snapdeal(DataTable userData) throws InterruptedException {
	    List<List<String>> userInfo = userData.asLists(String.class);
	    userInfo.get(0);         // Inner List 1   (Outer list row 1--- index 0)
	    for(int j = 0; j<userInfo.size(); j++)   // Outer List
	    {
	    	for(int k=0; k<userInfo.get(j).size(); k++)   // Inner List
	    	{
	    		System.out.println("Table values by row " + j + " and index " + k + " : "+ userInfo.get(j).get(k));
	    	}
	    }
	}
}