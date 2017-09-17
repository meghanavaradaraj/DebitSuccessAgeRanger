package stepDefinitions;

import java.util.List;
import org.junit.Assert;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class apiStepDefinitions extends apiParameters{

	apiParameters apiParam = new apiParameters();
	apiMethods api = new apiMethods();

	@Given("^person is created via AddPerson API$")
	public void person_is_created_via_AddPerson_api(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			String age = data.get(i).get(2);
			String requestString = apiParam.getRequestString(firstName, lastName, age);
			api.addPerson(requestString);
		}
	}

	@When("^GetAllPeople API is called$")
	public void getallpeople_api_is_called() throws Throwable {
		responseMsg = api.getAllPpl();
	}

	@Then("^person details should be available$")
	public void person_details_should_be_available(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			String age = data.get(i).get(2);
			String ageGroup = data.get(i).get(3);
			char c='"';
			String resp = c+"FirstName"+c+":"+c+firstName+c+","+c+"LastName"+c+":"+c+lastName+c+","+c+"Age"+c+":"+age+","+c+"AgeGroup"+c+":"+c+ageGroup+c;
			Assert.assertTrue(responseMsg.contains(resp));
			
		}	
	}
	
	@Given("^person is deleted via DeletePerson API$")
	public void delete_api_is_called_with_the_id(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			String age = data.get(i).get(2);
			String ageGroup = data.get(i).get(3);
			id = api.getId(firstName, lastName, age, ageGroup);
			api.deletePerson(id);
		}
	}
	
	@Then("^person details should not be available$")
	public void person_details_should_not_be_available(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		for (int i = 1; i < data.size(); i++) {
			String firstName = data.get(i).get(0);
			String lastName = data.get(i).get(1);
			String age = data.get(i).get(2);
			String ageGroup = data.get(i).get(3);
			char c='"';
			String resp = c+"FirstName"+c+":"+c+firstName+c+","+c+"LastName"+c+":"+c+lastName+c+","+c+"Age"+c+":"+age+","+c+"AgeGroup"+c+":"+c+ageGroup+c;
			responseMsg = api.getAllPpl();
			Assert.assertFalse(responseMsg.contains(resp));
		}
	}
	
}
