Feature: Book Store Demo

	
    Scenario: Check the arrivals and add to basket
    
        Given Open the browser 
		When  Enter the URL "http://practice.automationtesting.in/"
		When Click on Shop Menu 
		When click on Home menu button 
		When Check whether the Home page has Three Arrivals only
		When Now click the "Thinking in HTML" image in the Arrivals
		Then Test whether it is navigating to next page where the user can add that book into his basket. 

        