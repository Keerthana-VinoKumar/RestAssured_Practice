package Day3;

import static io.restassured.RestAssured.given;



import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Extractingwholeresponse {

	public static void main(String[] args) {
		// Extracting full response object 
		System.out.println("Contract 2");
		 Response response = given().baseUri("https://jsonplaceholder.typicode.com")
		.contentType(ContentType.JSON)
		.when().get("/users/1")
		.then().log().all()
		.extract().response();
		 String name = response.jsonPath().getString("name");
		 String email = response.jsonPath().getString("email");
		 int statusCode = response.statusCode();
		 String header = response.header("Content-Type");
		 String city = response.jsonPath().getString("address.city");
		System.out.println("name is:" +name);
		System.out.println("name is:" +email);
		System.out.println("name is:" +statusCode);
		System.out.println("name is:" +header);
		System.out.println("name is:" +city);
		
	}

}
