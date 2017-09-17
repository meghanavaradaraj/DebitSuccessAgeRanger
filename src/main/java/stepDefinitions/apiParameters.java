package stepDefinitions;

public class apiParameters {

	public static String responseMsg;
	public static String id;
	public static String respString;
	
	public String getRequestString(String firstName, String lastName, String age) {
		return "{ \"Id\":0," + "\"FirstName\":\"" + firstName + "\"," + "\"LastName\":\"" + lastName + "\","
				+ "\"Age\":" + age + "," + "\"AgeGroup\":\"string\"}";
	}
	
	public String getResponseString(String firstName, String lastName, String age, String ageGroup) {
		char c='"';
		String respString = c+"FirstName"+c+":"+c+firstName+c+","+c+"LastName"+c+":"+c+lastName+c+","+c+"Age"+c+":"+age+","+c+"AgeGroup"+c+":"+c+ageGroup+c;
		return respString;
	}
	

	public String getId(String firstName, String lastName, String age, String ageGroup) {
		String[ ] personRecord = responseMsg.split(","+getResponseString(firstName, lastName, age, ageGroup));
		String personRec = new StringBuffer(personRecord[0]).reverse().toString();
		String[ ] getId = personRec.split(":");
		String id = new StringBuffer(getId[0]).reverse().toString();;
		return id;
	}
	
}
