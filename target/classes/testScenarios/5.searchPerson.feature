@SearchPerson 
Feature: Search Person Details 

Scenario: Search with person last name on Age Ranger page 
	Given user is on Age Ranger page 
	When person name is entered in the search field 
		|searchText|
		|Blake|
	Then person details are displayed 
		|firstName|lastName|age|ageGroup|
		|Wendi|Blake|20|Early twenties|
		
Scenario: Search with person first name on Age Ranger page 
	Given user is on Age Ranger page 
	When person name is entered in the search field 
		|searchText|
		|Wendi|
	Then person details are displayed 
		|firstName|lastName|age|ageGroup|
		|Wendi|Blake|20|Early twenties|
		
Scenario: Search with person first and last name that is not available on the age Ranger page 
	Given user is on Age Ranger page 
	When person name is entered in the search field 
		|searchText|
		|Mark|
	Then person details are not displayed 
		|firstName|lastName|
		|Mark|Olsen|
		
Scenario: Clear search field to display all records
	Given user is on Age Ranger page 
	When search field is cleared
	Then person details are displayed 
		|firstName|lastName|age|ageGroup|
		|Ashlie|Olsen|15|Teenager|
		|Jim|Parker|2|Child|	