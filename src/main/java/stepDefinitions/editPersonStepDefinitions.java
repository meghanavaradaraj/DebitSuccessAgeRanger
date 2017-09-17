package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class editPersonStepDefinitions extends baseMethods {

	private ageRangerMethods ar = new ageRangerMethods();

	@When("^Edit icon is clicked for a record$")
	public void edit_icon_is_clicked_for_a_record(DataTable arg1) throws Throwable {
		getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.id("searchText")));
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			ar.clickEditIcon(firstName, lastName);
			captureScreenshot();
		}
	}

	@Then("^Edit Person modal window is displayed with person details$")
	public void edit_icon_modal_window_is_displayed_with_person_details(DataTable arg1) throws Throwable {
		Assert.assertEquals(true,
				getWebDriver().findElement(By.xpath("//h2[contains(text(),'Edit Person')]")).isDisplayed());
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			String age = data.get(i).get(2);
			ar.verifyPersonNameInHeader(firstName, lastName);
			ar.verifyPersonDetailsOnEditPopUp(firstName, lastName, age);
		}
	}

	@Given("^user is on Edit Person modal window$")
	public void user_is_on_edit_person_modal_window() {
		Assert.assertEquals(true,
				getWebDriver().findElement(By.xpath("//h2[contains(text(),'Edit Person')]")).isDisplayed());
	}
}
