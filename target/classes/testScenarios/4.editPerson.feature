@EditPerson 
Feature: Edit Person Details 

Scenario: Click Edit icon 
	Given user is on Age Ranger page 
	When Edit icon is clicked for a record
		|firstName|lastName|
		|John|Mathew|
	Then Edit Person modal window is displayed with person details 
		|firstName|lastName|age|
		|John|Mathew|0|
		
Scenario: Update person detials 
	Given user is on Edit Person modal window 
	When person details are submitted 
		|firstName|lastName|age|
		|Ashlie|Olsen|15|
	Then person details are saved and age group is determined 
		|firstName|lastName|age|ageGroup|
		|Ashlie|Olsen|15|Teenager| 
		
Scenario: Click Edit icon 
	Given user is on Age Ranger page 
	When Edit icon is clicked for a record
		|firstName|lastName|
		|Ashlie|Olsen|
	Then Edit Person modal window is displayed with person details 
		|firstName|lastName|age|
		|Ashlie|Olsen|15|
		
Scenario: Close Edit Person modal window 
	Given user is on Edit Person modal window 
	When Close button is clicked 
	Then modal window should be closed 