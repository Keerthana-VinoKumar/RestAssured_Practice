package Day3;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class ExtractingSingleValue {

	public static void main(String[] args) {
		// Contract 1 - Extracting Single Value
		System.out.println("Contract 1");
		int id = given().baseUri("https://jsonplaceholder.typicode.com")
		.contentType(ContentType.JSON)
		.when().get("posts/1")
		.then().log().all()
		.extract().path("id");
		System.out.println("id is:" +id);
		
		int userId = given().baseUri("https://jsonplaceholder.typicode.com")
				.contentType(ContentType.JSON)
				.when().get("posts/1")
				.then().log().all()
				.extract().path("userId");
				System.out.println("userId is:" +userId);
				
		String title = given().baseUri("https://jsonplaceholder.typicode.com")
				.contentType(ContentType.JSON)
				.when().get("posts/1")
				.then().log().all()
				.extract().path("title");
				System.out.println("title is:" +title);

	}

}
