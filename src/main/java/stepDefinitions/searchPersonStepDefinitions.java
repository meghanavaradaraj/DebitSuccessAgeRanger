package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class searchPersonStepDefinitions extends baseMethods{

	private ageRangerMethods ar = new ageRangerMethods();

	@When("^person name is entered in the search field$")
	public void person_name_is_entered_in_the_search_field(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String searchText = data.get(i).get(0);
			ar.searchPerson(searchText);
			captureScreenshot();
		}
	}
	
	@When("^search field is cleared$")
	public void search_field_is_cleared() {
		getWebDriver().findElement(By.id("searchText")).clear();
	}
	
}
