package stepDefinitions;

import static org.junit.Assert.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class apiMethods extends apiParameters{

	public String getAllPpl() {
		Response res = when().get("http://ageranger.azurewebsites.net/api/AgeRanger/GetAllPeople");
		String responseMessage = res.asString();
		System.out.println(responseMessage);
		assertEquals(200, res.getStatusCode());
		return responseMessage;
	}

	public void addPerson(String reqString) {
		Response addPerson = given().body(reqString).when().contentType(ContentType.JSON)
				.post("http://ageranger.azurewebsites.net/api/AgeRanger/AddPerson");
		assertEquals(204, addPerson.getStatusCode());
	}
	
	
	public void deletePerson(String reqString) {
		System.out.println(reqString);
		Response deletePerson = given().when().pathParam("id",reqString)
				.delete("http://ageranger.azurewebsites.net/api/AgeRanger/DeletePerson/{id}");
		assertEquals(204, deletePerson.getStatusCode());
	}

}
