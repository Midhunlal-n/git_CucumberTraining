Feature: Book Store Demo

	
    Scenario: Check the arrivals and add to basket
    
        Given Open the browser 
		And Navigate to expected url
		When Click on Shop Menu 
		And click on Home menu button 
		And Check whether the Home page has Three Arrivals only
		And Now click the image in the Arrivals
		Then Test whether it is navigating to next page where the user can add that book into his basket. 

        