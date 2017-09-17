package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class commonStepDefinitions extends baseMethods {

	private ageRangerMethods ar = new ageRangerMethods();

	@Given("^user is navigated to Age Ranger page$")
	public void user_is_navigated_to_Age_Ranger_page(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String url = data.get(i).get(0);
			ar.navigateToAgeRangerPage(url);
		}
	}
	
	@Given("^user is on Age Ranger page$")
	public void user_is_on_Age_Ranger_page() throws Throwable {
		getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.id("searchText")));
		}

	@When("^person detials are entered$")
	public void person_detials_are_entered(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			String age = data.get(i).get(2);
			ar.enterPersonDetails(firstName, lastName, age);
			captureScreenshot();
		}
	}

	@Then("^Submit button should be disabled$")
	public void submit_button_should_be_disabled() throws Throwable {
		Assert.assertEquals("true",
				getWebDriver().findElement(By.xpath("//button[text()='Submit']")).getAttribute("disabled"));
	}

	@Then("^Submit button should be enabled$")
	public void submit_button_should_be_enaabled() throws Throwable {
		Assert.assertNotEquals("true",
				getWebDriver().findElement(By.xpath("//button[text()='Submit']")).getAttribute("disabled"));
	}

	@Then("^validation message should be displayed$")
	public void validation_message_should_be_displayed(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String message = data.get(i).get(0);
			Assert.assertEquals(true, getWebDriver()
					.findElement(By.xpath("//p[contains(text()," + '"' + message + '"' + ")]")).isDisplayed());
			captureScreenshot();
		}
	}

	@When("^person details are cleared$")
	public void person_details_are_cleared() throws Throwable {
		ar.clearPersonDetails();
		captureScreenshot();
	}

	@Then("^first and last name should be displayed in the header$")
	public void first_and_last_name_should_be_displayed_in_the_header(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			ar.verifyPersonNameInHeader(firstName, lastName);
		}
	}

	@When("^Close button is clicked$")
	public void close_button_is_clicked() throws Throwable {
		getWebDriver().findElement(By.xpath("//button[text()='Close']")).click();
		getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.id("searchText")));
	}

	@Then("^modal window should be closed$")
	public void modal_window_should_be_closed() throws Throwable {
		Assert.assertEquals(true, getWebDriver().findElement(By.id("searchText")).isDisplayed());
	}

	@And("^Submit button is clicked")
	public void submit_button_is_clicked() throws Throwable {
		getWebDriver().findElement(By.xpath("//button[text()='Submit']")).click();
		getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']")));
	}

	@When("^OK button is clicked$")
	public void ok_button_is_clicked() throws Throwable {
		getWebDriver().findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(2000);
	}

	@Then("^person details are saved and age group is determined$")
	public void person_details_are_saved_and_age_group_is_determined(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			String age = data.get(i).get(2);
			String ageGroup = data.get(i).get(3);
			Thread.sleep(1000);
			ar.verifyPersonDetails(firstName, lastName, age, ageGroup);
		}
	}

	@Then("^confirmation pop up should be displayed$")
	public void confirmation_pop_up_should_be_displayed() throws Throwable {
		Assert.assertEquals(true, getWebDriver()
				.findElement(By.xpath("//div[contains(text(),'Are you sure you want to proceed?')]")).isDisplayed());
		captureScreenshot();
	}

	@Given("^user is on confirmation pop up$")
	public void user_is_on_confirmation_pop_up() throws Throwable {
		Assert.assertEquals(true, getWebDriver()
				.findElement(By.xpath("//div[contains(text(),'Are you sure you want to proceed?')]")).isDisplayed());
	}

	@When("^Cancel button is clicked$")
	public void cancel_button_is_clicked() throws Throwable {
		getWebDriver().findElement(By.xpath("//button[text()='Cancel']")).click();
		getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.name("FirstName")));
	}

	@Then("^confirmation pop up should be closed$")
	public void confirmation_pop_up_should_be_closed() throws Throwable {
		Assert.assertEquals(true, getWebDriver().findElement(By.name("FirstName")).isDisplayed());
	}

	@Then("person details are displayed$")
	public void person_details_are_displayed(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			String age = data.get(i).get(2);
			String ageGroup = data.get(i).get(3);
			ar.verifyPersonDetails(firstName, lastName, age, ageGroup);
		}
	}

	@Then("^person details are not displayed$")
	public void person_details_are_not_displayed(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			ar.verifyPersonDetailsNotPresent(firstName, lastName);
		}
	}

	@Given("^browser is closed$")
	public void browser_is_closed() {
		getWebDriver().close();
	}
	
	

}
