@DeletePerson 
Feature: Delete Person record 

Scenario: Delete Person record 
	Given user is on Age Ranger page 
	When Person record is deleted 
		|firstName|lastName|
		|Ashlie|Olsen|
		|Jim|Parker|
		|Sophia|Ran|
		|Wendi|Blake|
		|ABCDEFGHIJKLM|NOPQRSTUVWXYZ|
		|abcdefghijklm|nopqrstuvwxyz|
		|12345|67890|
		|ABCDEFGHIJKLMNOPQRSTUVWXYZ|abcdefghijklmnopqrstuvwxyz|
		|ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklm|nopqrstuvwxyz1234567890|
		|~`!@#$%^&*()_+|-=\{}[]:";<>?,./|
		|ABCDEFGHIJKLMNOPQRSTUVWXY abcdefghijklmnopqrstuvwxyxz1234567890 ~`!@#$%^&*()_+|-=\{}[]:";<>?,./|
		|Qwer toyu io pa sdfi iouguy rsepk vfdweu nopra xh Hu uy yuityu tyu ityt tyoip kl;op[ok kpoo ijjio pp fguhjj|[ mbvvxz seqw guhu frtdetu hiogyu gouyf ftyi gy itrt hniohutyu dfrfyuoo gyudeew nbjkfgch hgty|	
	Then person details are not displayed 
		|firstName|lastName|
		|John|Mathew|
 