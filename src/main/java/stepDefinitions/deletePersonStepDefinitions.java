package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class deletePersonStepDefinitions extends baseMethods {

	private ageRangerMethods ar = new ageRangerMethods();

	@When("^Person record is deleted$")
	public void person_record_is_deleted(DataTable arg1) throws Throwable {
		getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.id("searchText")));
		Thread.sleep(2000);
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			ar.clickDeleteIcon(firstName, lastName);
			Assert.assertEquals(true,
					getWebDriver()
							.findElement(By.xpath("//div[contains(text(), 'Are you sure you want to delete person "
									+ firstName + " " + lastName + "?')]"))
							.isDisplayed());
			captureScreenshot();
			getWebDriver().findElement(By.xpath("//button[text()='OK']")).click();
			getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.id("searchText")));
			Thread.sleep(3000);
		}
	}

	@Given("^user is on delete confirmation window$")
	public void user_is_on_delete_confirmation_window(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			Assert.assertEquals(true,
					getWebDriver()
							.findElement(By.xpath("//div[contains(text(), 'Are you sure you want to delete person "
									+ firstName + " " + lastName + " " + "?')]"))
							.isDisplayed());
		}
	}

	@Then("^Then person details are deleted$")
	public void person_details_are_deleted(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			ar.verifyPersonDetailsNotPresent(firstName, lastName);
		}
	}

	@Then("^delete confirmation window is displayed$")
	public void delete_confirmation_window_is_displayed(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			Assert.assertEquals(true,
					getWebDriver()
							.findElement(By.xpath("//div[contains(text(), 'Are you sure you want to delete person "
									+ firstName + " " + lastName + " " + "?')]"))
							.isDisplayed());
		}
	}

	@Then("^delete window is closed$")
	public void delete_window_is_closed() throws Throwable {
		Assert.assertEquals(true, getWebDriver().findElement(By.id("searchText")).isDisplayed());
	}
}
