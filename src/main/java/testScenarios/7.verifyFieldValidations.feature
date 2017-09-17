@VerifyFieldValidations 
Feature: Verify field validations 

Scenario: Click on Add icon 
	Given user is on Age Ranger page 
	When Add icon is clicked 
	Then New person modal window should be displayed 
	
Scenario: Verify field validation for Age when alpha numeric value is entered 
	Given user is on New Person modal window 
	When person detials are entered 
		|firstName|lastName|age|
		|John|Doe|1e|
	Then validation message should be displayed 
		|message|
		|Age is invalid.|	
		
Scenario: Verify field validation when First Name, Last Name and age fields are cleared 
	Given user is on New Person modal window 
	When person details are cleared 
	Then validation message should be displayed 
		|message|
		|First name is required.|
		|Last name is required.|
		|Age is invalid.|

Scenario: Close New Person modal window 
	Given user is on New Person modal window 
	When Close button is clicked 
	Then modal window should be closed 