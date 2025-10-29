Feature: Snapdeal Product Search

@ChromeBrowser @chrome @Sanity
Scenario: Search for the Product on chrome browser

And Launch the application
Then User is on the Home page
And Dismiss the popover if displayed
When Enter the required product to search
And Click on search button
Then Product search results should be displayed

@FirefoxBrowser @firefox
Scenario: Search for the Product on firefox browser

And Launch the application
Then User is on the Home page
And Dismiss the popover if displayed
When Enter the required product to search
And Click on search button
Then Product search results should be displayed

@IEBrowser @edge
Scenario: Search for the Product on ie browser

And Launch the application
Then User is on the Home page
And Dismiss the popover if displayed
When Enter the required product to search
And Click on search button
Then Product search results should be displayed