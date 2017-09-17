package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class addPersonStepDefnitions extends baseMethods {

	private ageRangerMethods ar = new ageRangerMethods();

	@When("^Add icon is clicked$")
	public void Add_icon_is_clicked() throws Throwable {
		getWebDriver().findElement(By.xpath("//i[contains(@class,'plus')]")).click();
		getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.name("FirstName")));
		captureScreenshot();
	}

	@Then("^New person modal window should be displayed$")
	public void new_person_modal_window_should_be_displayed() throws Throwable {
		Assert.assertEquals(true,
				getWebDriver().findElement(By.xpath("//h2[contains(text(),'New Person')]")).isDisplayed());
	}

	@When("^person details are submitted$")
	public void person_details_are_submitted(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			String age = data.get(i).get(2);
			ar.enterPersonDetails(firstName, lastName, age);
			captureScreenshot();
			getWebDriver().findElement(By.xpath("//button[text()='Submit']")).click();
			getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']")));
			Assert.assertEquals(true,
					getWebDriver().findElement(By.xpath("//div[contains(text(),'Are you sure you want to proceed?')]"))
							.isDisplayed());
			getWebDriver().findElement(By.xpath("//button[text()='OK']")).click();
			getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.id("searchText")));
			Thread.sleep(2000);
			if (i < data.size() - 1) {
				getWebDriver().findElement(By.xpath("//i[contains(@class, 'plus')]")).click();
				getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.name("FirstName")));
			}
			captureScreenshot();
		}
	}

	@Given("^user is on New Person modal window$")
	public void user_is_on_new_person_modal_window() throws Throwable {
		Assert.assertEquals(true,
				getWebDriver().findElement(By.xpath("//h2[contains(text(),'New Person')]")).isDisplayed());
	}

}
