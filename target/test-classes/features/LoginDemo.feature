Feature: Login Feature Demo

Background:
    Given Browser is launched
    And Navigated to url "https://www.saucedemo.com/"
	
	
    Scenario: Login with valid credentials
        When User enters username "standard_user" and password "secret_sauce"
        Then User should be redirected to the homepage
        And User should be able to Logout
        
        
  	Scenario Outline: Login with Invalid credentials
        When User enters username "<username>" and password "<password>"
        Then Error button should be displayed
        Examples:
            | username 		 | password       |
            | standard_user	 | secret_pass    |
            | user   		 | secret_sauce   |
