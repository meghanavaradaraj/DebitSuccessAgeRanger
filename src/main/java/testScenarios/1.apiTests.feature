@APITests 
Feature: Verify addition and deletion of person details using Age Ranger APIs 

Scenario: Add Person details using AddPerson API and verify Person being added using GetAllPeople API 
	Given person is created via AddPerson API 
		|firstName|lastName|age|ageGroup|
		|APIFirst|APILast|0|Toddler|
	When GetAllPeople API is called 
	Then person details should be available 
		|firstName|lastName|age|ageGroup|
		|APIFirst|APILast|0|Toddler|
		
Scenario: Delete Person record using DeletePerson API 
	Given person is deleted via DeletePerson API 
		|firstName|lastName|age|ageGroup|
		|APIFirst|APILast|0|Toddler|
	When GetAllPeople API is called 
	Then person details should not be available 
		|firstName|lastName|age|ageGroup|
		|APIFirst|APILast|0|Toddler|
		
