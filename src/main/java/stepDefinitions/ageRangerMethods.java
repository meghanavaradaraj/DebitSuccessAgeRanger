package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ageRangerMethods extends baseMethods {
	public void navigateToAgeRangerPage(String url) throws IOException {
		getWebDriver().get(url);
		getWebDriver().manage().window().maximize();
		getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.id("searchText")));
		Assert.assertEquals(true, getWebDriver().findElement(By.xpath("//h3[text()='People']")).isDisplayed());
		captureScreenshot();
	}

	public void enterPersonDetails(String firstName, String lastName, String age) {
		getWebDriver().findElement(By.name("FirstName")).clear();
		getWebDriver().findElement(By.name("FirstName")).sendKeys(firstName);
		getWebDriver().findElement(By.name("LastName")).clear();
		getWebDriver().findElement(By.name("LastName")).sendKeys(lastName);
		getWebDriver().findElement(By.name("Age")).clear();
		getWebDriver().findElement(By.name("Age")).sendKeys(age);
	}

	public void verifyPersonDetailsOnEditPopUp(String firstName, String lastName, String age) {
		Assert.assertEquals(getWebDriver().findElement(By.name("FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(getWebDriver().findElement(By.name("LastName")).getAttribute("value"), lastName);
		Assert.assertEquals(getWebDriver().findElement(By.name("Age")).getAttribute("value"), age);
		;
	}

	public void clearPersonDetails() {
		getWebDriver().findElement(By.name("FirstName")).clear();
		getWebDriver().findElement(By.name("LastName")).clear();
		getWebDriver().findElement(By.name("Age")).clear();
	}

	public void verifyPersonDetails(String firstName, String lastName, String age, String ageGroup) throws InterruptedException {
		Thread.sleep(2000);
		String bodyText = getWebDriver().findElement(By.tagName("body")).getText();
		Assert.assertEquals(true, bodyText.contains(firstName));
		Assert.assertEquals(true, bodyText.contains(lastName));
		Assert.assertEquals(true, bodyText.contains(age));
		Assert.assertEquals(true, bodyText.contains(ageGroup));
	}

	public void verifyPersonNameInHeader(String firstName, String lastName) {
		String header = firstName + " " + lastName;
		Assert.assertEquals(true, getWebDriver()
				.findElement(By.xpath("//h2[contains(text()," + '"' + header + '"' + ")]")).isDisplayed());
	}

	public void clickEditIcon(String firstName, String lastName) {
		String header = firstName + " " + lastName;
		getWebDriver()
				.findElement(By.xpath(
						"//td[contains(text(),'" + header + "')]/following-sibling::td/a/i[contains(@class,'pencil')]"))
				.click();
		getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.name("FirstName")));
	}

	public void verifyPersonDetailsNotPresent(String firstName, String lastName) {
		Assert.assertEquals(false, getWebDriver().getPageSource().contains(firstName + " " + lastName));
	}

	public void clickDeleteIcon(String firstName, String lastName) throws InterruptedException {
		String header = firstName + " " + lastName;
		Thread.sleep(2000);
		getWebDriver().findElement(By.xpath("//td[contains(text(),'" + header + "')]/following-sibling::td/a/i[contains(@class,'trash')]")).click();
		getWaitObj().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OK']")));
	}

	public void searchPerson(String searchText) throws InterruptedException {
		getWebDriver().findElement(By.id("searchText")).clear();
		getWebDriver().findElement(By.id("searchText")).sendKeys(searchText);
		Thread.sleep(4000);
	}

}
