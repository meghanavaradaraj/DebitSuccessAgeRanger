@AddPerson 
Feature: Add Person Details 

Scenario: Click on Add icon 
	Given user is on Age Ranger page 
	When Add icon is clicked 
	Then New person modal window should be displayed 
	
Scenario: Add Person details and verify Age Group 
	Given user is on New Person modal window 
	When person details are submitted 
		|firstName|lastName|age|
		|John|Mathew|0|
		|Jim|Parker|2|
		|Sophia|Ran|14|
		|Wendi|Blake|20|
		|ABCDEFGHIJKLM|NOPQRSTUVWXYZ|25|
		|abcdefghijklm|nopqrstuvwxyz|30|
		|12345|67890|50|
		|ABCDEFGHIJKLMNOPQRSTUVWXYZ|abcdefghijklmnopqrstuvwxyz|70|
		|ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklm|nopqrstuvwxyz1234567890|99|
		|~`!@#$%^&*()_+|-=\{}[]:";<>?,./|110|
		|ABCDEFGHIJKLMNOPQRSTUVWXY abcdefghijklmnopqrstuvwxyxz1234567890 ~`!@#$%^&*()_+|-=\{}[]:";<>?,./|199|
		|Qwer toyu io pa sdfi iouguy rsepk vfdweu nopra xh Hu uy yuityu tyu ityt tyoip kl;op[ok kpoo ijjio pp fguhjj|[ mbvvxz seqw guhu frtdetu hiogyu gouyf ftyi gy itrt hniohutyu dfrfyuoo gyudeew nbjkfgch hgty|4999|
	Then person details are saved and age group is determined 
		|firstName|lastName|age|ageGroup|
		|John|Mathew|0|Toddler|
		|Jim|Parker|2|Child|
		|Sophia|Ran|14|Teenager|
		|Wendi|Blake|20|Early twenties|
		|ABCDEFGHIJKLM|NOPQRSTUVWXYZ|25|Almost thirty|
		|abcdefghijklm|nopqrstuvwxyz|30|Very adult|
		|12345|67890|50|Kinda old|
		|ABCDEFGHIJKLMNOPQRSTUVWXYZ|abcdefghijklmnopqrstuvwxyz|70|Old|
		|ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklm|nopqrstuvwxyz1234567890|99|Very old|
		|~`!@#$%^&*()_+|-=\{}[]:";<>?,./|110|Crazy ancient|
		|ABCDEFGHIJKLMNOPQRSTUVWXY abcdefghijklmnopqrstuvwxyxz1234567890 ~`!@#$%^&*()_+|-=\{}[]:";<>?,./|199|Vampire|
		|Qwer toyu io pa sdfi iouguy rsepk vfdweu nopra xh Hu uy yuityu tyu ityt tyoip kl;op[ok kpoo ijjio pp fguhjj|[ mbvvxz seqw guhu frtdetu hiogyu gouyf ftyi gy itrt hniohutyu dfrfyuoo gyudeew nbjkfgch hgty|4999|Kauri tree|
		
Scenario: Click on Add icon 
	Given user is on Age Ranger page 
	When Add icon is clicked 
	Then New person modal window should be displayed 
	
Scenario: Verify if Person Name is populated in New Person window header when First Name and Last Name are entered 
	Given user is on New Person modal window 
	When person detials are entered 
		|firstName|lastName|age|
		|John|Mathew||
	Then first and last name should be displayed in the header 
		|firstName|lastName|
		|John|Mathew|
		
Scenario: Close New Person modal window 
	Given user is on New Person modal window 
	When Close button is clicked 
	Then modal window should be closed 